package scala
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.{ Actor,  ActorRef, ActorSystem }
import scala.TestActor.Send
import scala.TestActor.Sub
import scala.MessageBrokerActor.Subscribe


object TestActor {
  case class Send(actor: ActorRef, msg: String)
  case class Sub(actor: ActorRef, topic: String)
}

class TestActor extends Actor{
  def receive: Receive = {

    case Send(actor, msg) =>
      actor ! msg

    case msg: String =>
      println(msg)

    case Sub(actor, topic) =>
      actor ! Subscribe(topic)
  }
}