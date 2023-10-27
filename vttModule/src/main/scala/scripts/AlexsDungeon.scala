package scripts

//import uk.co.alexknight.foundryTypes.Hooks

import scala.scalajs.js
import scala.scalajs.js.annotation.*

@js.native @JSImport("/module.json", JSImport.Default)
val moduleJson: String = js.native

@main
def AlexsDungeon(): Unit =
  println("Hello world!")
//  Hooks.on(
//    "init",
//    () => {
//      println("Test")
//    }
//  )
//  Hooks.on(
//    "ready",
//    () => {
//      println("Test")
//    }
//  )
end AlexsDungeon
