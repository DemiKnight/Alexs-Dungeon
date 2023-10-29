import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.*
import sbt.{Def, *}
import sbt.Keys.*
import org.scalajs.linker.interface.ModuleSplitStyle
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport.*

object Dependencies {
  lazy val laminar = "16.0.0"
  lazy val scalaJSDom = "2.4.0"

  lazy val frontendDeps: Def.Initialize[Seq[sbt.ModuleID]] = Def.setting(
    Seq(
      "org.scala-js" %%% "scalajs-dom" % scalaJSDom,
      "com.raquo" %%% "laminar" % laminar,
      "com.raquo" %%% "airstream" % laminar
    )
  )

  val zioVersion = "2.0.18"
  val zioQuillVersion = ""
  val zioConfigVersion = ""

  val backendDeps: Def.Initialize[Seq[ModuleID]] = Def.setting(
    Seq(
      "dev.zio" %% "zio" % "2.0.18"
    )
  )

}
