import java.util.Collections
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Main extends App {
  //1 +
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
    val maxi = candies.max
    val ans = for (num <- candies) yield num + extraCandies >= maxi
    ans

  }
  //kidsWithCandies(Array(2,3,5,1,3),  3)
  //kidsWithCandies(Array(4,2,1,1,2),  1)

  //2 +
  case class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def getDecimalValue(head: ListNode): Int = {
    def rec(a: ListNode, b: String = ""): String = {
      if (a.next == null) b + a.x.toString
      else
        rec(a.next, b + a.x.toString)
    }
    Integer.parseInt(rec(head), 2)
  }

  //3 +
  def smallerNumbersThanCurrent(nums: Array[Int]): Unit = {
    val ans: Array[Int] = for(i <- nums) yield{
      nums.count(_ < i)
    }
    ans
  }
  //println(smallerNumbersThanCurrent(Array(8,1,2,2,3)))
  //smallerNumbersThanCurrent(Array(6,5,4,8))

  //4 +
  def repeatedNTimes(A: Array[Int]): Int = {
    val ans : Array[Int] = for(i <- A) yield{
      A.count(_ == i)
    }
    val maxi = ans.max
    A(ans.indexOf(maxi))
  }
  //println(repeatedNTimes(Array(2,1,2,5,3,2)))
  //println(repeatedNTimes(Array(1,2,3,3)))

  //5 +
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    var ans = ArrayBuffer[Int]()
    for(i <- nums.indices by 2){
      ans ++= ArrayBuffer.fill(nums(i))(nums(i+1))
    }
    ans.toArray
  }
  //println(decompressRLElist(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))

  //6 +
  def sumZero(n: Int): Array[Int] = {
    if (n == 1)
      return Array(0)
    val result = (1 to (n/2)).to(Array).flatMap(x => Array(x, -x))
    if (n % 2 == 0)
      return  result
    else
      result :+ 0
  }
  //println(sumZero(1).mkString("Array(", ", ", ")"))

  //7 +
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Unit = {
    var arr = Array.ofDim[Int](mat.size)
    for(col <- Range(0, mat(0).size); row <- Range(0, mat.size)){
      arr(row) += mat(row)(col)
    }
    arr.zipWithIndex.sortBy(_._1).unzip._2.take(k)
  }
  //println(kWeakestRows(Array(Array(1, 1, 0), Array(1, 0, 0), Array(0, 1, 0)), 2))

  //8


  //9 +
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val ans = nums1.intersect(nums2)
    ans.distinct
  }
  //println(intersection(Array(4,9,5), Array(9,4,9,8,4)).mkString("Array(", ", ", ")"))
  //println(intersection(Array(1, 2, 2, 1), Array(2, 2)).mkString("Array(", ", ", ")"))

  //10 +
  def buildArray(target: Array[Int], n: Int): List[String] = {
    val numbers = List.range(1,n+1);
    var arr = List[String]()
    var i = 0;
    var j = 0;
    while (i < target.length) {
      if (target(i) == numbers(j)) {
        arr :+= "Push"
        i += 1
        j += 1
      } else {
        arr :+= "Push"
        arr :+= "Pop"
        j+=1
      }
    }
    arr
  }

  //println(buildArray(Array(1,3), 3))
  println(buildArray(Array(2,3,4), 4))
}
