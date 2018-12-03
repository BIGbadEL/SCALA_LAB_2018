package Lab6_gr3

import scala.annotation.tailrec

object zad1 {



  def main(args: Array[String]): Unit = {
    var z = 1.0
    @tailrec def bindAndExecute(unit: => Unit, result: List[Int] = List())(exe: ((Int,Int)) => Int )(list: List[(Int,Int)]): List[Int] ={
      unit
      if(list.isEmpty) result.reverse else {
        bindAndExecute(unit, result ++ List(exe(list.head)))(exe)(list.tail)
      }
    }

    def lam(a: (Int, Int)): Int = ((a._1 * a._2)/z).toInt

    val results1 = bindAndExecute{ z = 0.3; }{ lam }{ List( (4,6), (4,3), (8,1)) }
    println( results1 )
    val results2 = bindAndExecute{ z = -2.5; }{ lam }{ List( (4,6), (4,3), (8,1)) }
    println( results2 )

  }
}


// expected result
//List(26, 40, 80)
//List(-3, -4, -9)