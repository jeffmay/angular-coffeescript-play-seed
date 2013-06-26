package controllers.user

import models.user.User
import play.api.libs.json.Json._
import play.api.mvc.{Controller, Action}
import javax.inject.Singleton

@Singleton
class UserRest extends Controller {

  import models.user.Serializers._

  def get(username: String) = Action {
    Ok(toJson(User(username, "example")))
  }
}
