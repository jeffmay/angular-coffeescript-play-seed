package controllers

import controllers.user.UserRest
import play.api.test.FakeRequest
import play.api.test.Helpers._
import play.api.libs.json.Json
import models.user.User

object Helpers {

//  def x() = {
//    val result = (new UserRest).get("x")(FakeRequest())
//    status(result) must beEqualTo(OK)
//    contentType(result) must beSome("application/json")
//    charset(result) must beSome("utf-8")
//    val jsonResult = Json.parse(contentAsString(result))
//    val user = Json.fromJson[User](jsonResult).getOrElse(failure("Could not parse " + User))
//  }

}
