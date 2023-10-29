package uk.co.alexknight.dungeonServer

import zio.http.*
import uk.co.alexknight.dungeonServer.httpApi.encounterRoute
import uk.co.alexknight.dungeonServer.integrations.integrationResources

val frontendResources = encounterRoute

val httpResources = (frontendResources ++ integrationResources).toHttpApp