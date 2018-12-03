package Exercise

import scala.annotation.tailrec

object fib_tail_rec {

  @tailrec def fib_rec(i: Int, result1: Int = 0, result2: Int = 1): Int ={
    if(i == 1) result1 + result2 else fib_rec(i-1, result2, result2+result1)
  }

  def main(args: Array[String]): Unit = {
    println(fib_rec(5))
  }
}
