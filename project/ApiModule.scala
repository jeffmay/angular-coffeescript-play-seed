import sbt._
import Keys._


object ApiModule extends BaseModule {

  val moduleName = "api"

  val moduleVersion = "0.1"

  val location = "api"

  def settings = Seq(
    // Add your own project settings here
    testOptions in Test += Tests.Argument("junitxml", "console")
  )

  val libraries = Seq(
    Libraries.guice,
    Libraries.inject,
    Libraries.specs2 % "test",
    Libraries.mockito % "test"
  )

  lazy val project = baseProject

  override def baseProject = play.Project(moduleName, moduleVersion, libraries, file(location), moduleSettings)

}