package scala
import java.util.concurrent.Flow.Publisher
import scala.TestActor.Send
import scala.TestActor.Sub
import akka.actor.{ Actor,  ActorRef, ActorSystem, Props }
import scala.MessageBrokerActor.{Subscribe, Publish}

object Main {

  //tasks 1-3
//  def main(args: Array[String]): Unit = println("Hello PTR");
//  val list = List("Hello", "PTR")
//  list.foreach(item => println(item))

  //tasks 4-6

  val actorSystem = ActorSystem("MyActorSystem")

  val testActor1 = actorSystem.actorOf(Props[TestActor], "testActor1")
  val testActor2 = actorSystem.actorOf(Props[TestActor], "testActor2")
  val testActor3 = actorSystem.actorOf(Props[TestActor], "testActor3")
//  val listActor = actorSystem.actorOf(Props[ListActor], "listActor")
//  val echoToSenderActor = actorSystem.actorOf(Props[EchoToSenderActor], "echoToSenderActor")
  val messageBrokerActor = actorSystem.actorOf(Props[MessageBrokerActor], "messageBrokerActor")

//  echoActor1 ! "Hello, world!"
//
//  listActor ! "msg 1"
//  listActor ! "msg 2"
//  listActor ! "msg 3"
//
//  echoActor1 ! Send(echoToSenderActor, "msg 4")

  //Task 7-9
  testActor1 ! Sub(messageBrokerActor, "scala")
  Thread.sleep(500)
  messageBrokerActor ! Publish("scala", "Hello Subscriber 1!")

  testActor2 ! Sub(messageBrokerActor, "js")
  Thread.sleep(500)
  messageBrokerActor ! Publish("js", "Hello Subscriber 2!")


  testActor3 ! Sub(messageBrokerActor, "js")
  Thread.sleep(500)
  messageBrokerActor ! Publish("js", "Hello Subscriber 3!")

}

