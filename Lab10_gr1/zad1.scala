package Lab10_gr1
import math.max



object zad1 extends App{

  def repeated(ints: List[Int]): List[Int] ={
    ints.groupBy(element => element).filter(_._2.length > 1).toList.map(_._1)
  }

  def condMerge(list: List[Int], vec: Vector[Int],fun: PartialFunction[(Int, Int), Int]): List[Int] ={
    list.zip(vec).collect( fun )
  }

  println(repeated(List(-8,5,6,1,4,4,2,5,-1,9,9)))
  //List(5, 9, 4)
  val m = condMerge(List(2,-9,1,8), Vector(3,-2,45,2),
    {
      case x: (Int, Int) if max(x._1, x._2) > 0 => max(x._1,x._2)
    } )
  println(m)
//   List(3, 45, 8)

}
