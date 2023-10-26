package scripts

import uk.co.alexknight.foundryTypes.Hooks

import scala.scalajs.js.annotation.JSGlobalScope
import scalajs.*
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
