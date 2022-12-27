package scala
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.{ Actor,  ActorRef, ActorSystem }
import scala.collection.mutable.ListBuffer
import scala.MessageBrokerActor.{Subscribe, Publish}

object MessageBrokerActor {
  case class Subscribe(topic: String)
  case class Publish(topic: String, message: String)
}

class MessageBrokerActor extends Actor {
  var scalaSubscribers = ListBuffer[ActorRef]()
  var jsSubscribers = ListBuffer[ActorRef]()

  def receive: Receive = {
    case Subscribe(topic) =>
      if (topic == "scala"){
        scalaSubscribers += sender()
        println(s"Subscriber added: ${sender()} to scala topic")
        println(s"Total scala subscribers: ${scalaSubscribers.size}")
      } else if (topic == "js") {
        jsSubscribers += sender()
        println(s"Subscriber added: ${sender()} to js topic")
        println(s"Total js subscribers: ${jsSubscribers.size}")
      }

    case Publish(topic, message) =>
      if(topic == "scala") {
        scalaSubscribers.foreach(_ ! message)
        println(s"Message '$message' published to ${scalaSubscribers.size} scala subscribers")
      } else if (topic == "js") {
        jsSubscribers.foreach(_ ! message)
        println(s"Message '$message' published to ${jsSubscribers.size} js subscribers")
      }

  }
}