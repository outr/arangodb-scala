package com.outr.arango.api.model

/**
  * PutAPISimpleReplaceByExampleOptions
  *
  * @param limit an optional value that determines how many documents to
  *        replace at most. If *limit* is specified but is less than the number
  *        of documents in the collection, it is undefined which of the documents
  *        will be replaced.
  * @param waitForSync if set to true, then all removal operations will
  *         instantly be synchronized to disk. If this is not specified, then the
  *         collection's default sync behavior will be applied.
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class PutAPISimpleReplaceByExampleOptions(limit: Option[String] = None,
                                               waitForSync: Option[Boolean] = None)