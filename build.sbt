ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

val laminar = "16.0.0"

lazy val foundVttTypes = (project in file("foundryTypes"))
  .enablePlugins(ScalaJSPlugin)
  .settings(name := "Foundry Types")


lazy val frontend = (project in file("frontend"))
  .settings(name := "frontend")
//  .settings(libraryDependencies ++= Seq(
//    "com.raquo" %%% "laminar" % laminar,
//    "com.raquo" %%% "airstream" % laminar
//  ))

lazy val vttModule = (project in file("vttModule"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(foundVttTypes)
  .settings(name := "VTTModule",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % laminar,
      "com.raquo" %%% "airstream" % laminar
    ),
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv())

lazy val root = (project in file("."))
  .aggregate(vttModule, frontend)
  .settings(
    name := "AlexsDungeon"
  )
