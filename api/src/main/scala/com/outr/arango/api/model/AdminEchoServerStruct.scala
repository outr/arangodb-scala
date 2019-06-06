package com.outr.arango.api.model

import io.circe.Json

/**
  * AdminEchoServerStruct
  *
  * @param address the ip address of the client
  * @param id a server generated id
  * @param port port of the client side of the tcp connection
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class AdminEchoServerStruct(address: Option[Int] = None,
                                 id: Option[String] = None,
                                 port: Option[Int] = None)