ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

val foundVttTypes = (project in file("foundryTypes"))
  .enablePlugins(ScalaJSPlugin)
  .settings(name := "Foundry Types")

val vttModule = (project in file("vttModule"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(foundVttTypes)
  .settings(name := "VTTModule",
    scalaJSUseMainModuleInitializer := true,
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv())

lazy val root = (project in file("."))
  .aggregate(vttModule)
  .settings(
    name := "AlexsDungeon"
  )
