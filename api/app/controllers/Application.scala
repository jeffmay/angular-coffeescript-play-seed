package controllers

import play.api.mvc.{Controller, Action}
import views.html

object Application extends Controller {

  def index = Action {
    Ok(html.index())
  }

}
