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
    Libraries.specs2 % "test",
    Libraries.mockito % "test"
  )

  val appName = "angular-seed-play"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
   Libraries.WebJars.angular,
   "org.webjars" % "requirejs" % "2.1.1",
   "org.webjars" % "webjars-play" % "2.1.0-1")



  def project = baseProject

  override def baseProject = play.Project(moduleName, moduleVersion, libraries, file(location), moduleSettings)

}