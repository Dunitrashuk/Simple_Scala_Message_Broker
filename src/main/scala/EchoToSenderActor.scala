package scala
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.{ Actor,  ActorRef, ActorSystem }

class EchoToSenderActor extends Actor {
  def receive: Receive = {
    case message: String => sender() ! message
  }
}