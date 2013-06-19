package models

import common.Model
import play.api.libs.json.Json

package object user {

  object Serializers {
    implicit lazy val userJsonWriter = Json.writes[User]
    implicit lazy val userJsonReader = Json.reads[User]
  }

  case class User(username: String, name: String) extends Model

}