package Exercise

object exp_tail_rec {

  def exp_rec(x: Int, i: Int, result: Int = 1): Int=
    if(i == 0) result else exp_rec(x, i-1, result * x)

  def main(args: Array[String]): Unit = {
    println(exp_rec(2,3))
  }
}
