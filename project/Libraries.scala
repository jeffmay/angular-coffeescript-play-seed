import sbt._

object Libraries {

  object WebJars {

    lazy val angular = "org.webjars" % "angularjs" % "1.1.5"

    lazy val play = "org.webjars" % "webjars-play" % "2.1.0-1"

    lazy val requireJs = "org.webjars" % "requirejs" % "2.1.1"
  }

  lazy val guice = "com.google.inject" % "guice" % "3.0"

  lazy val inject = "javax.inject" % "javax.inject" % "1"

  lazy val mockito = "org.mockito" % "mockito-core" % "1.9.5"

  lazy val specs2 = "org.specs2" %% "specs2" % "2.0"

  lazy val typesafeConfig = "com.typesafe" % "config" % "1.0.0"
}
