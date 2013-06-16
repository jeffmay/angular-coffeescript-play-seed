package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import views._

import play.api.db._
import play.api.Play.current
 
import anorm._
import anorm.SqlParser._ 


object Application extends Controller {

  /**
   * Describes the hello form.
   */
  val helloForm = Form(
    tuple(
      "name" -> nonEmptyText,
      "repeat" -> number(min = 1, max = 100),
      "color" -> optional(text)
    )
  )

  val result = false

  // -- Actions

  /**
   * Home page
   */
  def index = Action { implicit request =>
  DB.withConnection { implicit c =>

    val result: Boolean = SQL("Select 1").execute()    
    println("Datasource result: " + result)
    Ok(html.index(helloForm))  
  }
  }

  /**
   * Handles the form submission.
   */
  def sayHello = Action { implicit request =>

  helloForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.index(formWithErrors)),
      {case (name, repeat, color) => Ok(html.hello(name, repeat.toInt, color))}
    )
  }
  
 
 
  
  
  
}
