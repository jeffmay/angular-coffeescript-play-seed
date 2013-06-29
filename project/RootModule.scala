import coffeescript.Plugin.coffeeSettings
import sbt._

object RootModule extends BaseModule {

  val moduleName = "root"

  val location = "."

  val moduleVersion = "0.1"

  val libraries = Seq()

  lazy val project = baseProject

  def settings = coffeeSettings

  override def baseProject = Project(moduleName, file(location), settings = moduleSettings)
    .aggregate(
      ApiModule.project,
      WebModule.project
    )

}
