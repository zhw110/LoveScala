package code.api

/**
  * Created by zhanghongwei on 11/11/16.
  */
class Chapter2(val description: String, val price: Double) {

  val x = 5
  if (x > 0) 1 else -1
  if (x > 0) print(2) else print(3)
  val s = if (x > 0) 1 else -1
  // it can be only a val.
  var s1 = 0 // this must bea var
  if (x > 0) s1 = 1 else s1 = -1

  final override def equals(other: Any) = {
    val that = other.asInstanceOf[Chapter2]
    if (that == null) false
    else description == that.description && price == that.price
  }

  final override def hashCode() = 13 * description.hashCode + 17 * price.hashCode()
}

object Chapter2 {

  def decorate(str: String, left: String = "[", right: String = "]") = left + str + right;

  def abs(x: Int) = if (x >= 0) x else -x

  def fac(n: Int) = {
    //n=5
    var r = abs(4)
    for (i: Int <- 1 to n) r = r * i
    r
  }

  def facRec(n: Int): Int = if (n <= 0) 1 else n * facRec(n - 1)

  def main(args: Array[String]): Unit = {

    val abs1: Int = abs(4)
    val fac1: Int = fac(10)
    val distance = {
      val x0 = 0.5
      val x = 1
      val dx = x - x0
      val y0 = 0.5
      val y = 1
      val dy = y - y0
      scala.math.sqrt(dx * dx + dy * dy)
    }
    val x = 5
    val y = 6
    val z = ()
    val zz = Unit
    val x1 = null


    print(if (1 > 0) -1)
    print(if (1 > 0) "Hongwei" else if (3 > 2) 2 else 3.0)
    var a = 5
    var c = Unit
    printAny("helo")
    println()
    printUnit("yanhong")
    val s = 5 + 6 + //
      7 + 9 + //
      1 + 2 //
    3 + 4
    var s1 = 5

    //    val name = readLine("Your name:")
    //    print("Your age :")
    //    val age = readLine()
    //    println(age)

    var n = 10
    var r = 5
    while (n > 0) {
      r = r * n
      n -= 1
    }

    for (i <- 1 to 10) // let is retrever all the values in the right
      r = r * i

    for (i <- 0 until "hongwei".length)
      print(i)

    for (ch <- "hello")
      print(ch)

    for (i <- 1 to 3; j <- 1 to 3 if i != j)
      print((10 * i + j) + " ")

    val a6 = for {
      i <- 1 to 10
      if i > 5
      a7 = 1000
    } yield {
      i
      a7
    } // for {} yield {} 是 for 推导式.与第一个生成器的类型兼容!


    val a7 = for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
    val a8 = for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
    val a9 = for (c <- "Hello") yield c
    val a10 = for (c <- "Hello") yield c.toChar

    val a5 = a6
    //2.7 function
    // method operates on object, function not

    decorate("Hongwei")

  }

  def printAny(x: Any) {
    print(x)
  }

  def printUnit(x: Unit) {
    print(x)
  }


}