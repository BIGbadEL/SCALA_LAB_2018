import scala.annotation.tailrec

object Test {
  def main(args: Array[String]): Unit = {
    @tailrec def mmerge(ints: List[Int], ints1: List[Int], out: List[Int] = List()): List[Int] ={
      var tout = out
      if(ints.isEmpty && ints1.isEmpty) out
      else{
        if(ints.isEmpty){
          tout = tout ++ List(ints1.head)
        } else if(ints1.isEmpty){
          tout = tout ++ List(ints.head)
        } else if(ints.head >= ints1.head){
          tout = tout ++ List(ints.head)
        } else{
          tout = tout ++ List(ints1.head)
        }
        mmerge(ints.tail,ints1.tail,tout)
      }
    }

    // example to work with
    val testList1 = List(9,5,2,1,-5)
    val testList2 = List(15,9,5,-1,-90)
    val mergedTestList = mmerge( testList1, testList2 )
    println( mergedTestList.mkString(" ") )
    // result
    //15 9 9 5 5 2 1 -1 -5 -90

  }
}
