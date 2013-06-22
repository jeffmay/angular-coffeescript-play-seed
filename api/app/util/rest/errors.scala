package object errors {

  sealed trait RestError

  // Figure this out
  case class NotFound[T](key: Map[String, String]) extends RestError

}


