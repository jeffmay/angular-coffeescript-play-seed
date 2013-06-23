import sbt._
import Keys._

object MyDefaults {
  lazy val settings =
    Defaults.defaultSettings ++ Seq (
      organization := "jeffmay.me",
      version      := Versions.mine,
      scalaVersion := Versions.scala
    ) ++ Seq (
      scalacOptions += "-feature",
      scalacOptions += "-unchecked",
      scalacOptions += "-deprecation"
    ) ++ Seq (
      resolvers ++= Seq(
        Resolver.sbtPluginRepo("releases"),
        Resolver.sonatypeRepo("snapshots"),
        Resolver.sonatypeRepo("releases")
//        "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
//        "releases"  at "http://oss.sonatype.org/content/repositories/releases"
      )
    )
}