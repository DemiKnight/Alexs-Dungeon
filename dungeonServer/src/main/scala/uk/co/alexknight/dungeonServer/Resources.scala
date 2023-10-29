package uk.co.alexknight.dungeonServer

import zio.http.*
import uk.co.alexknight.dungeonServer.api.encounterRoute
import uk.co.alexknight.dungeonServer.integrations.integrationResources

val frontendResources = encounterRoute

val httpResources = (frontendResources ++ integrationResources).toHttpApp