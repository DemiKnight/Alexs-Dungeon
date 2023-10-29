package uk.co.alexknight.dungeonServer.integrations.foundry.httpApi

import zio.http.*
 
val submitHook = Routes(
  Method.POST / "hook" -> handler(Response.text("foundry"))
)