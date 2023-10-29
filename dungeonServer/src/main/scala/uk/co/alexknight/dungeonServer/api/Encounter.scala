package uk.co.alexknight.dungeonServer.api

import zio.http.*
import zio.http.Scheme.HTTP

val encounterRoute: Routes[Any, Nothing] = Routes(
  Method.GET / "controller"/"encounter" -> handler(Response.text("Test")),
  Method.POST / "controller" / "encounter" -> handler(Response.text("Text2"))
)

