package com.outr.arango.api.model

/**
  * GeneralGraphCreateHttpExamplesRc400
  *
  * @param error Flag if there was an error (true) or not (false).
  *        It is true in this response.
  * @param code The response code.
  * @param errorMessage A message created for this error.
  * @param errorNum ArangoDB error number for the error that occured.
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class GeneralGraphCreateHttpExamplesRc400(error: Boolean,
                                               code: Option[Int] = None,
                                               errorMessage: Option[String] = None,
                                               errorNum: Option[Int] = None)