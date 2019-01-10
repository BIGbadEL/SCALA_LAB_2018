package Exercise

import scala.util.Random


object GenericAlgorithms extends App{

  def mySlowSort[T <: Ordered[T]](input: List[T]): List[T] = {
    if(input.tail.isEmpty) input
      else{
      val pivot = input.length / 2

      var temp_list: List[T] = List()

//      input.foreach(
//        if (_ > input(pivot)) {
//          temp_list = temp_list ++ _
//        } else {
//          temp_list = _ ++ temp_list
//        }
//      )

      val temp = temp_list.splitAt(pivot)
      List.concat(
        temp._1,
        temp._2
      )

    }

  }

  class Point(val x: Int, val y: Int) extends Ordered[Point]{
    override def compare(that: Point): Int = x - that.x + y - that.y
    override def toString: String = "(" + x + ", " + y + ")"
  }

  def P : Point = new Point(Random.nextInt() % 20 , Random.nextInt() % 20)

  val list = List.range(0,10).map(_ => P)

  println(list)

  println(mySlowSort(list))

}
