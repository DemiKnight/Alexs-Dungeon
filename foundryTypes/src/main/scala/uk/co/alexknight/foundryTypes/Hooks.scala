package uk.co.alexknight.foundryTypes

import scala.scalajs.js.annotation.JSGlobal
import scalajs.*

@js.native
@JSGlobal
object Hooks extends js.Object {
  def on(event: String, fn: () => Unit): Unit = js.native
}
