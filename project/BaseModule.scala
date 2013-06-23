import sbt._
import Keys._

trait BaseModule {
  def moduleName: String
  def location: String

  lazy val moduleSettings = baseSettings ++ settings

  def settings: Seq[Project.Setting[_]]

  lazy val baseSettings =
    MyDefaults.settings ++
    Seq (
      name := moduleName
    ) ++ Seq (
      libraryDependencies ++= libraries
    )

  def libraries: Seq[ModuleID]

  def baseProject = Project(
    id = moduleName,
    base = file(location),
    settings = moduleSettings
  )

  def project: Project

}
