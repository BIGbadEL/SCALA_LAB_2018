package Exercise

import scala.annotation.tailrec

object fac_tail_rec {

  @tailrec def fac_rec(i: Int, result: Int = 1): Int =
    if(i < 2) result else fac_rec(i - 1, result * i)

  def main(args: Array[String]): Unit = {
    println(fac_rec(10))
  }
}
