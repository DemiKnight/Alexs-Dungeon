package frontend

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import com.raquo.laminar.api.L.{*, given}
import com.raquo.airstream.{*, given}
import java.util.UUID

case class Combatantant(displayName: String, playerName: String, UUIDstr: String)

val eventList: Seq[Combatantant] = Seq(Combatantant("xxxx", "hello", "dd82dd28-d498-40ac-a5b8-6836a8eeef28"))

def renderCombatant(combatantID: String, initial: Combatantant, combatantSignal: Signal[Combatantant]): HtmlElement = {
  li(
    button("<"),
    span(child <-- combatantSignal.map(_.displayName)),
    button(">")
  )
}


val list: EventStream[Seq[Combatantant]] = EventStream.fromSeq(Seq(eventList))

val toDoList: Element = ol(children <-- list.split(_.UUIDstr)(renderCombatant))
val friendlyList: Element = ol(children <-- list.split(_.UUIDstr)(renderCombatant))
val enemyList: Element = ol(children <-- list.split(_.UUIDstr)(renderCombatant))
val listContainer: Element = div(
  friendlyList,
  toDoList,
  enemyList
)
