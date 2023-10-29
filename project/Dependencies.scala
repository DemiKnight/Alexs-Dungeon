import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.*
import sbt.*
import sbt.Keys.*
import org.scalajs.linker.interface.ModuleSplitStyle
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport.*


object Dependencies {
  val laminar = "16.0.0"
  val scalaJSDom = "2.4.0"

  val frontendDeps: Seq[ModuleID] = Seq(
    "org.scala-js" %%% "scalajs-dom" % scalaJSDom,
    "com.raquo" %%% "laminar" % laminar,
    "com.raquo" %%% "airstream" % laminar
  )

   val zioVersion = "2.0.18"
  val zioQuillVersion = ""
  val zioConfigVersion = ""

  val backendDeps: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio" % "2.0.18"
  )

}
