import coffeescript.Plugin.{CoffeeKeys, coffeeSettings}
import sbt._
import sbt.Keys._

object WebModule extends BaseModule {

  val moduleName = "web"

  val moduleVersion = "0.1"

  val location = "web"

  def settings = coffeeSettings ++ Seq(
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

  lazy val project = baseProject

  override def baseProject = play
    .Project(moduleName, moduleVersion, libraries, file(location), moduleSettings)
    .settings(
      // where coffee task reads source files
      sourceDirectory in (Compile, CoffeeKeys.coffee) <<= (sourceDirectory in Compile)(_ / "coffee"),
      // where coffee task compiles javascript
      resourceManaged in (Compile, CoffeeKeys.coffee) <<= baseDirectory (_ / "public" / "js")
    )

}
