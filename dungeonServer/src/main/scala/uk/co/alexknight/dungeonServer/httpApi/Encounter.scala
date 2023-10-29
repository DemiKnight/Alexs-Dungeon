package uk.co.alexknight.dungeonServer.httpApi

import uk.co.alexknight.dungeonServerApi.api.EncounterRequest
import zio.http.*
import zio.http.Scheme.HTTP

val newEncounter: EncounterRequest = EncounterRequest("test")

val encounterRoute: Routes[Any, Nothing] = Routes(
  Method.GET / "controller"/"encounter" -> handler(Response.text("Test")),
  Method.POST / "controller" / "encounter" -> handler(Response.text("Text2"))
)

