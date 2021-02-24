object Main extends App {
  var res : Boolean = true
  var line: String = ""
  while (res) {
    var s : String = scala.io.StdIn.readLine()
    line = line.concat(s)
    if (s.contains("=")) {
      line = line.replace("=", "")
      res = false
    }
  }
  print(new Utils start(line))
}
