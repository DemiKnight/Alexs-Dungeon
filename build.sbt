import org.scalajs.linker.interface.ModuleSplitStyle

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

val laminar = "16.0.0"
val scalaJSDom = "2.4.0"

lazy val foundVttTypes = (project in file("foundryTypes"))
  .enablePlugins(ScalaJSPlugin)
  .settings(name := "Foundry Types")

lazy val dungeonServer = (project in file("dungeonServer"))

lazy val frontend = (project in file("frontend"))

lazy val vttModule = (project in file("vttModule"))
  .dependsOn(foundVttTypes)


lazy val root = (project in file("."))
  .aggregate(vttModule, frontend, foundVttTypes, dungeonServer)
  .settings(
    name := "AlexsDungeon"
  )
