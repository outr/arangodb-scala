package com.outr.arango

case class IndexInfo(`type`: String,
                     fields: Option[List[String]] = None,
                     unique: Option[Boolean] = None,
                     sparse: Option[Boolean] = None,
                     id: Option[Id[IndexInfo]] = None,
                     isNewlyCreated: Option[Boolean] = None,
                     selectivityEstimate: Option[Int] = None,
                     error: Boolean = false,
                     code: Int = 0)