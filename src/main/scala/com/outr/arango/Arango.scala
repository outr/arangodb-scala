package com.outr.arango

import com.outr.arango.rest.{AuthenticationRequest, AuthenticationResponse}
import io.circe.{Decoder, Encoder}
import io.circe.generic.auto._
import io.youi.client.HttpClient
import io.youi.http.{Headers, HttpResponse, Method}
import io.youi.net.URL

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Arango(baseURL: URL = Arango.defaultURL) {
  private var disposed: Boolean = false
  private val client = new HttpClient

  protected[arango] def defaultErrorHandler[Response]: HttpResponse => Response = (response: HttpResponse) => {
    throw new RuntimeException(s"Error from server: ${response.status} with content: ${response.content}")
  }

  protected[arango] def restful[Request, Response](path: String,
                                                   request: Request,
                                                   token: Option[String],
                                                   params: Map[String, String] = Map.empty,
                                                   errorHandler: HttpResponse => Response = defaultErrorHandler[Response],
                                                   method: Method = Method.Post)
                                                  (implicit encoder: Encoder[Request], decoder: Decoder[Response]): Future[Response] = {
    val headers = token.map(t => Headers.empty.withHeader(Headers.Request.Authorization(s"bearer $t"))).getOrElse(Headers.empty)
    val url = baseURL.withPath(path).withParams(params)
    client.restful[Request, Response](url, request, headers, errorHandler, method)
  }

  protected[arango] def call[Response](path: String,
                                       method: Method,
                                       token: Option[String],
                                       params: Map[String, String] = Map.empty,
                                       errorHandler: HttpResponse => Response = defaultErrorHandler[Response])
                                      (implicit decoder: Decoder[Response]): Future[Response] = {
    val headers = token.map(t => Headers.empty.withHeader(Headers.Request.Authorization(s"bearer $t"))).getOrElse(Headers.empty)
    val url = baseURL.withPath(path).withParams(params)
    client.call[Response](url, method, headers, errorHandler)
  }

  def auth(username: String = Arango.defaultUsername,
           password: String = Arango.defaultPassword): Future[ArangoSession] = {
    restful[AuthenticationRequest, AuthenticationResponse]("/_open/auth", AuthenticationRequest(username, password), None).map { response =>
      new ArangoSession(this, response.jwt)
    }
  }

  def isDisposed: Boolean = disposed

  def dispose(): Unit = {
    client.dispose()
    disposed = true
  }
}

object Arango {
  var defaultURL: URL = URL(Option(System.getenv("ARANGO_URL")).getOrElse("http://localhost:8529"))
  var defaultUsername: String = Option(System.getenv("ARANGO_USERNAME")).getOrElse("root")
  var defaultPassword: String = Option(System.getenv("ARANGO_PASSWORD")).getOrElse("root")
}