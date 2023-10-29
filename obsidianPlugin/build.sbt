import Dependencies.scalaJSDeps
import org.scalajs.linker.interface.ModuleSplitStyle

libraryDependencies ++= scalaJSDeps.value
enablePlugins(ScalaJSPlugin, ScalablyTypedConverterPlugin) // Enable the Scala.js plugin in this project

name := "ObsidianPlugin"

scalaVersion := "3.3.1"

scalaJSUseMainModuleInitializer := true

scalaJSLinkerConfig ~= {
  _.withModuleKind(ModuleKind.CommonJSModule)
    .withModuleSplitStyle(
      ModuleSplitStyle.SmallModulesFor(List("vttModule"))
    )
    .withSourceMap(false) // causes warnings in vite
}
Compile / npmDependencies ++= Seq(
  "obsidian" -> "1.4.11"
)