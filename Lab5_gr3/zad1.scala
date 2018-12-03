package Lab5_gr3

import scala.annotation.tailrec

object zad1 {

  class btree( val data: Int, var left: btree = null, var right: btree = null ){
    @scala.annotation.tailrec
    final def add( x: Int ) {
      if ( x < data ) {
        if ( left != null )
          left.add(x)
        else {
          println("adding left:"+x)
          left = btree(x)
        }
      } else {
        if ( right != null )
          right.add(x)
        else {
          println("adding right:"+x)
          right = btree(x)
        }
      }
    }
  }

  object btree {
    def apply( x: Int* ): btree = {
      val b = new btree(x(0))
      for ( el <- x.splitAt(1)._2 ) b.add(el)
      b
    }
  }


  def str(btree: zad1.btree): List[Int] ={
    @tailrec def help(nodes: List[btree], result: List[Int] = List()): List[Int] ={
      if(nodes.isEmpty) result else{
        if(nodes.head.left == null && nodes.head.right == null) help(nodes.tail, result ++ List(nodes.head.data))
        else if(nodes.head.left == null) help(nodes.tail ++ List(nodes.head.right), result ++ List(nodes.head.data))
        else if(nodes.head.right == null) help(nodes.tail ++ List(nodes.head.left), result ++ List(nodes.head.data))
        else help(nodes.tail ++ List(nodes.head.left, nodes.head.right), result ++ List(nodes.head.data))
      }
    }
    help(List(btree))
  }

  def main(args: Array[String]): Unit = {
    val testTree = btree( 3,4,2,4,9,1,5,6,6,7,7)
    println(  str(testTree) )
  }
}
