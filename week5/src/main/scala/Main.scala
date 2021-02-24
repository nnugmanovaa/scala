object Main extends App {
  def maxProduct(nums: Array[Int]): Int = {
    var maxi = -1
    var secondMaxi = -1
    for (num <- nums) {
      if (num > maxi) {
        secondMaxi = maxi
        maxi = num
      }
      else if (num > secondMaxi) {
        secondMaxi = num
      }
    }
    (maxi - 1) * (secondMaxi - 1)
  }

  //println(maxProduct(Array(1,5,4,5)))

  def average(salary: Array[Int]): Double = {
    var maxi = -1
    var mini = 1000000
    var result = 0
    for (s <- salary) {
      if (s > maxi) {
        maxi = s
      }
      if (s < mini) {
        mini = s
      }
      result += s
    }
    var avg: Double = (result - maxi - mini) / (salary.length - 2)
    avg
  }

  //println(average(Array(4000,3000,1000,2000)))

  def dayOfTheWeek(day: Int, month: Int, year: Int): Any = {


    def visGod(year: Int): Int = {
      if ((year % 4 == 0 && year % 100 != 0) | year % 400 == 0) return 1
      0
    }

    def sumUpYear(year: Int, days: List[Int]): Int = {
      var sum = 0
      for (i <- 0 until 12) {
        if (i == 1) sum += visGod(year)
        sum += days(i)
      }
      sum
    }

    def sumUpMonth(month: Int, year: Int, days: List[Int]): Int = {
      var total = 0
      total += days(month)
      if (month == 1) total += visGod(year)
      total
    }

    val week = List[String]("Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val days = List[Int](31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var totalDays = 4
    for (i <- 1971 until year) {
      totalDays += sumUpYear(i,days)
    }
    for (i <- 0 until (month-1)) {
      totalDays += sumUpMonth(i, year, days)
    }
    week((totalDays + day) % 7)
  }

  //println(dayOfTheWeek(18, 7, 1999))

  def findPairs(nums: Array[Int], k: Int): Int = {
    if (k < 0)
      0
    else if (k == 0)
      nums.groupBy(identity).count(_._2.length > 1)
    else {
      val s = nums.toSet
      s.count(n => s.contains(n + k))
    }
  }

 // println(findPairs(Array(1,2,3,4,5), 1))
}


