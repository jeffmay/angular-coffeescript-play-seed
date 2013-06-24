import sbt._
import Keys._


object WebModule extends BaseModule {

  val moduleName = "web"

  val moduleVersion = "0.1"

  val location = "web"

  def settings = Seq(
    // Add your own project settings here
    testOptions in Test += Tests.Argument("junitxml", "console")
  )

  val libraries = Seq(
    Libraries.WebJars.angularJs,
    Libraries.WebJars.requireJs,
    Libraries.WebJars.play,
    Libraries.specs2 % "test",
    Libraries.mockito % "test"
  )

  def project = baseProject

  override def baseProject = play.Project(moduleName, moduleVersion, libraries, file(location), moduleSettings)

}