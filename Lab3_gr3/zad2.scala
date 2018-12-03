package Lab3_gr3

import scala.annotation.tailrec

object zad2 {

  @tailrec def reverse(list: List[Int], result: List[Int] = List()): List[Int] =
    if(list.isEmpty) result else reverse(list.tail, list.head :: result)

  @tailrec def mmerge(left: List[Int], right: List[Int],result: List[Int] = List()): List[Any] ={
    if(left.isEmpty && right.isEmpty) reverse(result)  else
      if(left.isEmpty) mmerge(left, right.tail,right.head :: result) else
        if(right.isEmpty) mmerge(left, right.tail,right.head :: result) else
          if(left.head > right.head)
            mmerge(left.tail, right,left.head :: result)
          else
            mmerge(left, right.tail, right.head :: result)
  }



  def main(args: Array[String]): Unit = {

    val testList1 = List(9,5,2,1,-5)
    val testList2 = List(15,9,5,-1,-90)


    val mergedTestList = mmerge( testList1, testList2 )
    println( mergedTestList.mkString(" ") )

  }
}
