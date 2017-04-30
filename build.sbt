name := """play-scala-anorm"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

val playVersion = "2.5.0"

libraryDependencies ++= Seq(jdbc, cache, ws, evolutions)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "anorm" % playVersion,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

TwirlKeys.templateImports += "models._"