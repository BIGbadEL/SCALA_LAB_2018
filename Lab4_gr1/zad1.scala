package Lab4_gr1

import scala.annotation.tailrec

object zad1 {

  @tailrec def sumfrac(i: Int, d: Double, sum: Double = 1, element: Double = 1): Double = {
      val temp = element / i
      if (temp < d) sum else sumfrac(i, d, sum + temp, temp)
  }

  def main(args: Array[String]): Unit = {

    val sum1 = sumfrac(3, 1e-3 )
    val sum2 = sumfrac(5, 1e-9 )

    println(sum1, sum2)
  }
}
