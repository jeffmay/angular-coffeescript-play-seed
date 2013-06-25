import sbt._
import Keys._

object MyDefaults {
  lazy val settings =
    Defaults.defaultSettings ++ Seq (
      organization := "jeffmay.me",
      version      := Versions.mine,
      scalaVersion := Versions.scala,
      scalacOptions += "-feature",
      scalacOptions += "-unchecked",
      scalacOptions += "-deprecation",
      resolvers ++= Seq(
        Resolver.sbtPluginRepo("releases"),
        Resolver.sonatypeRepo("snapshots"),
        Resolver.sonatypeRepo("releases")
      )
    )
}