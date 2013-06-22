import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "righttrack"
    val appVersion      = "0.1"

    val appDependencies = Seq(
      "com.google.inject" % "guice" % "3.0",
      "javax.inject" % "javax.inject" % "1",

      "org.mockito" % "mockito-core" % "1.9.5" % "test"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here      
      testOptions in Test += Tests.Argument("junitxml", "console")
    )

}