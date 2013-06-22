package controllers.user

import models.user.User
import play.api.libs.json.Json._
import play.api.mvc.Action
import javax.inject.Singleton
import controllers.RestController

@Singleton
class UserRest extends RestController {

  import models.user.Serializers._

  def get(username: String) = Action {
    Ok(toJson(User(username, "example")))
  }
}
