package uk.co.alexknight.dungeonServer.integrations.obsidianmd.api

import zio.http.*

val submitNote = Routes(
  Method.PUT / "note" -> handler(Response.text("notes..."))
)
 
