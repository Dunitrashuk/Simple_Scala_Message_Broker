package scala
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.{ Actor,  ActorRef, ActorSystem }

class ListActor extends Actor {
  private var messageList: List[String] = Nil

  def receive: Receive = {
    case message: String =>
      messageList = message :: messageList
      println(s"Received message: $message")
      println(s"Message list: $messageList")
  }
}