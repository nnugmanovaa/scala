object Operation extends Enumeration {
  type Operation = Value
  val ADD, SUBTRACT, DIVIDE, MULTIPLY = Value

  def getOperation(c :Char): Operation = {
    c match {
      case '+' => ADD
      case '-' => SUBTRACT
      case '/' => DIVIDE
      case '*' => MULTIPLY
    }
  }
}



