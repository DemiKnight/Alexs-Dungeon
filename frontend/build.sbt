import org.scalajs.linker.interface.ModuleSplitStyle


val laminar = "16.0.0"

lazy val frontend = project.in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .settings(
    name := "Frontend",
    scalaVersion := "3.3.1",

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "frontend" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("frontend")))
    },

    /* Depend on the scalajs-dom library.
     * It provides static types for the browser DOM APIs.
     */
    libraryDependencies ++= Seq("org.scala-js" %%% "scalajs-dom" % "2.4.0",
      "com.raquo" %%% "laminar" % laminar,
      "com.raquo" %%% "airstream" % laminar ),
  )