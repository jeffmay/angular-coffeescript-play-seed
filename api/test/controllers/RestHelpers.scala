package controllers

import org.specs2.execute.Result
import org.specs2.mutable
import play.api.libs.json.{JsValue, Writes, Reads, Json}
import play.api.mvc
import play.api.test.Helpers._
import scala.reflect.runtime.universe._

trait RestHelpers {
  this: mutable.Specification =>

  def withJsonResult[T](result: mvc.Result)(test: T => Result)
    (implicit reader: Reads[T], writer: Writes[T], typeTag: TypeTag[T]): Result = {
    test(parseJsonContent(result))
  }

  def withValidJsonResult[T](result: mvc.Result)(test: T => Result)
    (implicit reader: Reads[T], writer: Writes[T], typeTag: TypeTag[T]): Result = {
    status(result) must beEqualTo(OK)
    contentType(result) must beSome("application/json")
    charset(result) must beSome("utf-8")
    test(parseJsonContentOrElse(result, jsonResult =>
      failure("Could not parse " + typeOf[T] + " from:\n" + jsonResult))
    )
  }

  def parseJsonContent[T](result: mvc.Result)
    (implicit reader: Reads[T], writer: Writes[T], typeTag: TypeTag[T]): T = {
    parseJsonContentOrElse(result, jsonResult =>
      throw new NoSuchElementException("Could not parse " + typeOf[T] + " from:\n" + jsonResult)
    )
  }

  private def parseJsonContentOrElse[T](result: mvc.Result, orElse: JsValue => T)
    (implicit reader: Reads[T], writer: Writes[T], typeTag: TypeTag[T]): T = {
    val jsonResult = Json.parse(contentAsString(result))
    Json.fromJson[T](jsonResult) getOrElse orElse(jsonResult)
  }

}
