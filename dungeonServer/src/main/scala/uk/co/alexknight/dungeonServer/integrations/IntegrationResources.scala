package uk.co.alexknight.dungeonServer.integrations

import uk.co.alexknight.dungeonServer.integrations.foundry.api.submitHook
import uk.co.alexknight.dungeonServer.integrations.obsidianmd.api.submitNote
import zio.http.Routes

val foundryHttpApi = submitHook

val obsidianMdHttpApi = submitNote 

val integrationResources: Routes[Any, Nothing] = foundryHttpApi ++ obsidianMdHttpApi
