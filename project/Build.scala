import coffeescript.Plugin.{CoffeeKeys, coffeeSettings}
import sbt._
import sbt.Keys._

object ApplicationBuild extends Build {

  val appName = "righttrack"
  val appVersion = "0.1"

  val appDependencies = Seq(
    "com.google.inject" % "guice" % "3.0",
    "com.typesafe" % "config" % "1.0.0",
    "javax.inject" % "javax.inject" % "1",
    "org.mockito" % "mockito-core" % "1.9.5" % "test",
    "org.specs2" %% "specs2" % "2.0" % "test",
    "org.webjars" % "angularjs" % "1.1.5",
    "org.webjars" % "requirejs" % "2.1.1",
    "org.webjars" % "webjars-play" % "2.1.0-1"
  )

  val main = play.Project(appName, appVersion, appDependencies)
    // Default coffee settings
    .settings(coffeeSettings: _*)
    // Overrides for coffee settings
    .settings(
      // where coffee task reads source files
      sourceDirectory in (Compile, CoffeeKeys.coffee) <<= (sourceDirectory in Compile)(_ / "coffee"),
      // where coffee task compiles javascript
      resourceManaged in (Compile, CoffeeKeys.coffee) <<= baseDirectory (_ / "public" / "js")
    )

}
