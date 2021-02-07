object Hello extends App {
  def ex1(): Unit = {
    val x = 1;
    var y = 1;
    y += 2
    println(x)
    println(y)
  }

  def ex2(a:Int, b:Int): Int = {
    a + b
  }

  def ex3(a:Int, b:Int): Int = {
    val minValue = if (a < b) a else b
    minValue
  }

  def ex4(i:Int):String = {
    i match {
      case 1 => "one"
      case 2 => "two"
      case _  => "not one or two"
    }
  }

  def ex5(): Unit = {
    val x = for (i <- 1 to 5) yield i * 2
    println(x)
  }

  def ex6(): Unit = {
    val fruits = List("apple", "banana", "lime", "orange")

    val fruitLengths = for {
      f <- fruits
      if f.length > 4
    } yield f
    println(fruitLengths)
  }

  def ex7(): Int = {
    var x = 3
    while(x < 10) {
      x+=2
    }
    x
  }

  ex1()
  println(ex2(5, 4))
  println(ex3(2, 3))
  println(ex4(5))
  ex5()
  ex6()
  println(ex7())
}
