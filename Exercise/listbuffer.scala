package Exercise

import scala.collection.mutable.ListBuffer

object listbuffer extends App {

  def dlist(arg: Seq[Int]): Unit ={
    for(i <- arg) print(i + " ")
    println()
  }

  val a = ListBuffer[Int](1,3,2,4,5)
  a += 56
  dlist(a)
  val b = List[Int](1,7,6,3)
  dlist(b)

}
