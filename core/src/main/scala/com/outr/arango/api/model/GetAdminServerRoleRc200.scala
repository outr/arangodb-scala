package com.outr.arango.api.model

/**
  * GetAdminServerRoleRc200
  *
  * @param error always *false*
  * @param code the HTTP status code, always 200
  * @param errorNum the server error number
  * @param role one of [ *SINGLE*, *COORDINATOR*, *PRIMARY*, *SECONDARY*, *AGENT*, *UNDEFINED*]
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class GetAdminServerRoleRc200(error: Boolean,
                                   code: Option[Long] = None,
                                   errorNum: Option[Long] = None,
                                   role: Option[String] = None)