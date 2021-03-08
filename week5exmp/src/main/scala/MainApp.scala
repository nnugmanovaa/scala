import PingManager.{Command, PingAll}
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import org.slf4j.{Logger, LoggerFactory}

object MainApp extends App{
  def f1(): Unit = {
    implicit val log: Logger = LoggerFactory.getLogger(getClass)

    val system: ActorSystem[HelloWorldMain.SayHello] =
      ActorSystem(HelloWorldMain(), "hello")

    system ! HelloWorldMain.SayHello("World")
    system ! HelloWorldMain.SayHello("Akka")
  }

  def f2(): Unit = {
    class Prefixer(val prefix:String)
    def addPrefix(s:String)(implicit p: Prefixer) = p.prefix + s
    implicit val myPrefix = new Prefixer("***")
    println(addPrefix("abc"))
  }

  def f3(): Unit ={
    val system: ActorSystem[Command] =
      ActorSystem(PingManager(), "ping-pong")

    system ! PingAll
  }

}
