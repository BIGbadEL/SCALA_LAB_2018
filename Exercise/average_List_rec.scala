package Exercise

import scala.annotation.tailrec

object average_List_rec {

  @tailrec def average_rec(list: List[Int], sum: Double = 0, n: Int = 0): Double =
    if(list.isEmpty) sum / n else average_rec(list.tail, sum + list.head, n + 1)

  def main(args: Array[String]): Unit = {
    println(average_rec(List(1,2,3,4,5,6,7,8,9,10)))
  }
}
