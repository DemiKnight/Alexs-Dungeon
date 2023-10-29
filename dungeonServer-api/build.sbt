import sbt.*
import Dependencies.*
import org.scalajs.linker.interface.ModuleSplitStyle


name := "DungeonServer-API"

scalaVersion := "3.3.1"

libraryDependencies := scalaJSDeps.value
scalaJSUseMainModuleInitializer := true

enablePlugins(ScalaJSPlugin)

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
      ModuleSplitStyle.SmallModulesFor(List("frontend"))
    )
    .withSourceMap(false) // causes warnings in vite
}
