package uk.co.alexknight.dungeonServer.integrations

import uk.co.alexknight.dungeonServer.integrations.foundry.httpApi.submitHook
import uk.co.alexknight.dungeonServer.integrations.obsidianmd.httpApi.submitNote
import zio.http.Routes

val foundryHttpApi = submitHook

val obsidianMdHttpApi = submitNote

val integrationResources: Routes[Any, Nothing] = foundryHttpApi ++ obsidianMdHttpApi
