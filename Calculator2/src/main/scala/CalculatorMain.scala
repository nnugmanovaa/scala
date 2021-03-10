import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object CalculatorMain {

  final case class StartCalculate(name: String)

  def apply(): Behavior[StartCalculate] =
    Behaviors.setup { context =>
      val greeter = context.spawn(CalculatorDriver(), "start")

      Behaviors.receiveMessage { message =>
        val replyTo = context.spawn(CalculatorLogic(), message.name)
        greeter ! CalculatorDriver.Calculate(message.name, replyTo)
        Behaviors.same
      }
    }

}
