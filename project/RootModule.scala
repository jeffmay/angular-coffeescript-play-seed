import sbt._
import Keys._
import Modules._

object RootModule {

  lazy val project = Project(
    id = "root",
    base = file("."),
    settings = moduleSettings
  ).aggregate(
    ApiModule.project
  ).settings(
    scalaVersion := Versions.scala
  )

  val moduleSettings = MyDefaults.settings

}
