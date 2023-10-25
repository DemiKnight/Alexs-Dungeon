ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

val vttModule = (project in file("vttModule"))
  .settings(name := "VTTModule")

lazy val root = (project in file("."))
  .aggregate(vttModule)
  .settings(
    name := "AlexsDungeon"
  )
