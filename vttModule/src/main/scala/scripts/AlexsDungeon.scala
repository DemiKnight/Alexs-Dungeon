package scripts

import uk.co.alexknight.foundryTypes.Hooks

import scala.scalajs.js.annotation.{JSGlobalScope, JSImport}
import scalajs.*

@js.native @JSImport("/module.json", JSImport.Default)
val moduleJson: String = js.native

object AlexsDungeon {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    Hooks.on("init", () => {
      println("Test")
    })
    Hooks.on("ready", () => {
      println("Test")
    })
  }
}
