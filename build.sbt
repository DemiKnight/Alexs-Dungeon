import org.scalajs.linker.interface.ModuleSplitStyle

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

val laminar = "16.0.0"
val scalaJSDom = "2.4.0"

lazy val foundVttTypes = (project in file("foundryTypes"))
  .enablePlugins(ScalaJSPlugin)
  .settings(name := "Foundry Types")

lazy val frontend = (project in file("frontend"))
//  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
//  .settings(
//    name := "Frontend",
//    scalaVersion := "3.3.1",
//
//    // Tell Scala.js that this is an application with a main method
//    scalaJSUseMainModuleInitializer := true,
//
//    /* Configure Scala.js to emit modules in the optimal way to
//     * connect to Vite's incremental reload.
//     * - emit ECMAScript modules
//     * - emit as many small modules as possible for classes in the "frontend" package
//     * - emit as few (large) modules as possible for all other classes
//     *   (in particular, for the standard library)
//     */
//    scalaJSLinkerConfig ~= {
//      _.withModuleKind(ModuleKind.ESModule)
//        .withModuleSplitStyle(
//          ModuleSplitStyle.SmallModulesFor(List("frontend"))
//        )
//        .withSourceMap(false) // causes warnings in vite
//    },
//
//    /* Depend on the scalajs-dom library.
//     * It provides static types for the browser DOM APIs.
//     */
//    libraryDependencies ++= Seq(
//      "org.scala-js" %%% "scalajs-dom" % scalaJSDom,
//      "com.raquo" %%% "laminar" % laminar,
//      "com.raquo" %%% "airstream" % laminar
//    )
//  )

lazy val vttModule = (project in file("vttModule"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(foundVttTypes)
  .settings(
    name := "vttModule",
    scalaVersion := "3.3.1",
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "vttModule" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("vttModule"))
        )
        .withSourceMap(false) // causes warnings in vite
    },

    /* Depend on the scalajs-dom library.
     * It provides static types for the browser DOM APIs.
     */
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % scalaJSDom
    )
  )

lazy val root = (project in file("."))
  .aggregate(vttModule, frontend, foundVttTypes)
  .settings(
    name := "AlexsDungeon"
  )
