package Lab3

import scala.annotation.tailrec

object zad1 {
  def concat(str: String*):String = {
    @tailrec def help(strings: List[String], result: String = ""): String =
      if(strings.isEmpty) result else help(strings.tail, result + strings.head)
    help(str.toList)
  }

  def ret(arg: Int): Int = arg

  def max(x: Int = Int.MinValue)(y: Int = Int.MinValue):Int => Int = (z: Int) =>{
    if(x > y && x > z) x else if( y > z )  y else z
  }


  def <(str: String): Unit= println(str)
  def <<():Unit = println()

  def main(args: Array[String]): Unit = {

    println( concat("hello") )
    println( concat("hello", " all") )
    println( concat("hello", " all", " the") )
    println( concat("hello", " all", " the", " word", " and", " all", " people") )
    <( "here we are again")
    << // prints empty line
    println( max(3)(5)(1) )
    println( max(3)(5)(8) )
    println( max(9)(5)(8) )
    val rangeMax =  max()(100)
    println( rangeMax(200) )
    println( rangeMax(2) )

  }

}
