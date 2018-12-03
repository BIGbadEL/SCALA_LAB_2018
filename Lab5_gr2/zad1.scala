package Lab5_gr2

import scala.annotation.tailrec
import scala.math.abs

object zad1 {
  def main(args: Array[String]): Unit = {

    def redux(i: Int*)(fun:(Int,Int) => Int): Int = {
      @tailrec def help(list: List[Int], result: Int ): Int ={

        if(list.isEmpty) result else{
          val temp  = fun(list.head,list(1))
            help(list.tail.tail, fun(result,temp))
        }
      }

      help(i.toList.tail, i.head)
    }

    println(redux( 1,7,8,9,10)( _+_ )) // == 35
    println(redux( 2,-4,5,-2,4)( _*abs(_) ) )// == 320

  }
}
