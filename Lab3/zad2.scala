package Lab3

import scala.annotation.tailrec
import scala.math.abs

object zad2 {
  def leng(x: Int, y: Int): Int = abs(x - y)
  def leng(x: (Int, Int)): Int = abs(x._1 - x._2)

  def closest(num: Int*):(Int,Int)={

    val length = num.toList.length
    @tailrec def fun1(list: List[Int], i: Int = 0, j: Int = 1, result: (Int, Int) = (0, 10)): (Int,Int) ={
      if(i == length || j == length) result else{
        if(leng(list(i), list(j)) < leng(result._1, result._2)){
          fun1(list, i, j+1,(list(i), list(j)))
        }else{
          fun1(list, i, j+1,result)
        }
      }
    }

    @tailrec def fun2(list: List[Int],i: Int = 0, tuple: (Int, Int) = (0,10)): (Int, Int) ={
      if(i == list.length) tuple else{
        val temp = fun1(list, i, i+1)
        if(leng(tuple) > leng(temp)) fun2(list, i+1, temp) else fun2(list, i+1, tuple)
      }
    }

    fun2(num.toList)
  }

  def main(args: Array[String]): Unit = {

    val c = closest( 1, 17, 8, 27, 21, 29, 99, 22 , 4)
    println("" + c._1 + " " + c._2 )

  }

}
