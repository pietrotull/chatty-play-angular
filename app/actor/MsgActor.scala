package actor

import akka.actor.{ActorRef, Props, Actor}
import play.api.Logger

/**
 * Created by TGDKEPI1 on 12.10.2014.
 */

object MsgActor {
  def props(out: ActorRef) = Props(new MsgActor(out))
  var actors: Seq[ActorRef] = Seq()

  def broadcast(msg: String) = {
    actors.map(_ ! msg)
  }
}

class MsgActor(out: ActorRef) extends Actor {

  MsgActor.actors = MsgActor.actors :+ out
  Logger.info("Added new ActorRef: " + MsgActor.actors.length)

  override def receive = {
   case msg: String =>
     Logger.info ("Got msg!: " + msg)
     MsgActor.broadcast(msg)
 }

  def broadcast(msg: String) = {
    MsgActor.actors.map(_ ! msg)
  }
}
