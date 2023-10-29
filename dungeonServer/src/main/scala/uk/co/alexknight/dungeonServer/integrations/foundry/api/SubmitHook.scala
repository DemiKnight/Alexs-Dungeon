package uk.co.alexknight.dungeonServer.integrations.foundry.api

import zio.http.*
 
val submitHook = Routes(
  Method.POST / "hook" -> handler(Response.text("foundry"))
)