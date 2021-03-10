import akka.actor.typed.ActorSystem
import org.slf4j.{Logger, LoggerFactory}

object Main extends App {

  implicit val log: Logger = LoggerFactory.getLogger(getClass)

  var res : Boolean = true
  var line: String = ""

  val system: ActorSystem[CalculatorMain.StartCalculate] = ActorSystem(CalculatorMain(), "calculator")
  log.info("Calculator started \n")

  while (res) {
    var s : String = scala.io.StdIn.readLine()
    line = line.concat(s)
    if (s.contains("=")) {
      line = line.replace("=", "")
      res = false
    }
    system ! CalculatorMain.StartCalculate(line)
  }
}
