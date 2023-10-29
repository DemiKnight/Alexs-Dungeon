import Dependencies.*
import org.scalajs.linker.interface.ModuleSplitStyle

libraryDependencies ++= scalaJSDeps.value
enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project

name := "vttModule"

scalaVersion := "3.3.1"

jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv()

// Tell Scala.js that this is an application with a main method
scalaJSUseMainModuleInitializer := true

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
}
