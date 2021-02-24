import Operation._

import scala.collection.mutable

class Utils {
  object Constants {
    val error = "Invalid input"
  }

  var nums: mutable.Stack[BigDecimal] = mutable.Stack[BigDecimal]()
  var operations: mutable.Stack[Operation] = mutable.Stack[Operation]()

  var x = 0
  var oneOperation = false

  def start(line: String): String = {
    for (char <- line) {
      char match {
        case a if char.isDigit =>
          x = x * 10 + a.asDigit
          oneOperation = false
        case _ =>
          nums.push(x)
          x = 0
          if (oneOperation) {
            return Constants.error
          }
          val newOp = Operation.getOperation(char)
          while (operations.nonEmpty) {
            calculation()
          }
          operations.push(newOp)
          oneOperation = true
      }
    }
    if (x > 0 | line(line.length - 1) == '0') nums.push(x)
    while (operations.nonEmpty & nums.length > 1) {
      calculation()
    }
    if (operations.nonEmpty) return Constants.error
    (nums.top).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString()
  }


  def calculate(x: BigDecimal, y: BigDecimal, c: Operation): BigDecimal = {
    c match {
      case ADD => x + y
      case SUBTRACT => y - x
      case MULTIPLY => x * y
      case DIVIDE => y / x
    }
  }

  def calculation(): Unit ={
    val c = operations.top
    operations.pop
    val firstVal = nums.top
    nums.pop
    val secondVal = nums.top;
    nums.pop
    nums.push(calculate(x = firstVal, y = secondVal, c))
  }
}
