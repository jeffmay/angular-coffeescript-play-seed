import sbt._

object Modules extends Build {

  lazy val root = RootModule.project

  lazy val api = ApiModule.project
}