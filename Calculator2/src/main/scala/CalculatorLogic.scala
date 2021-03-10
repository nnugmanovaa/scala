import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object CalculatorLogic {

  def apply(): Behavior[CalculatorDriver.Calculated] = {
    Behaviors.receive { (context, message) =>
      val result = new Utils start (message.whom)
      context.log.info(result)
      Behaviors.same
    }
  }

}
