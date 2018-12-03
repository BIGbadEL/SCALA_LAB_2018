package Exercise

object concat_list_rec {

  def concat(list: List[List[Int]], result: List[Int] = List()): List[Int] =
    if(list.isEmpty) result else concat(list.tail, result ++ list.head)

  def main(args: Array[String]): Unit = {
    println(concat(List(List(1,2), List(3,4), List(5,6))))
  }

}
