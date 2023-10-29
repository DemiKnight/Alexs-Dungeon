package uk.co.alexknight.dungeonServer

import zio.*
import zio.http.*

object DungeonServer extends ZIOAppDefault {

  val app: ZIO[Any with Server, Nothing, Unit] = for {
    _ <- ZIO.logInfo("Starting...")
    serverStatus <- Server.install(httpResources)
  } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = ???
}
