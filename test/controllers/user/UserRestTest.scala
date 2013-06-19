package controllers.user

import controllers.RestHelpers
import models.user.User
import models.user.Serializers._
import org.specs2.mutable.Specification
import play.api.test._

class UserRestTest extends Specification with RestHelpers {

  "UserRest" should {

    "return a user with the given username" in {
      withValidJsonResult[User]((new UserRest).get("username")(FakeRequest())) { user =>
        user.username must beEqualTo("username")
      }
    }
  }

}
