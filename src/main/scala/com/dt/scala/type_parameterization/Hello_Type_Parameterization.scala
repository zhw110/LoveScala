package com.dt.scala.type_parameterization

import scala.collection.immutable.Queue
/**
 * Author: 	Wang Jialin 
 * Date2015/7/4
 * Contact Information:
 * 	WeChat:	18610086859
 *  QQ:		1740415547
 * 	Email: 18610086859@126.com
 *  Tel:	18610086859
 */

class Triple[F, S, T](val first: F, val second: S, val third: T)

object Hello_Type_Parameterization {

  def main(args: Array[String]) {
    val triple = new Triple("Spark", 3, 3.1415)
    val bigData = new Triple[String, String, Char]("Spark", "Hadoop", 'R')
    
    def getData[T](list : List[T]) = list(list.length / 2)
    println(getData(List("Spark", "Hadoop", 'R')))
    val f = getData[Int] _
    println(f(List(1,2,3,4,5,6)))
    
    val queue = Queue(1,2,3,4,5)
    val queue_appended = queue enqueue 6
    println("queue : " + queue + "   " + "queue_appended : " + queue_appended)
    
  }

}