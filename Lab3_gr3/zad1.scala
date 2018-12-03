package Lab3_gr3

object zad1 {

  def mid(arg: (Int,Int)): Int => Int = (z: Int) =>{
     if(arg._1 > arg._2 && arg._1 < z) arg._1 else
     if(arg._1 < arg._2 && arg._1 > z) arg._1 else
     if(arg._1 < arg._2 && arg._2 < z) arg._2 else
     if(arg._1 > arg._2 && arg._2 > z) arg._2 else z
  }


  def @@(string: String ="")(x: Int = 1):Unit =
    if(x != 0){
      println(string)
      @@(string)(x-1)
    }

  def compose2(fun1: String => String, fun2: String => String): String => String = (s: String) => fun1(fun2(s))

  def main(args: Array[String]): Unit = {
    println( mid( (3,5) )(1) )
    println( mid( (3,5) )(8) )
    println( mid( (9,5) )(8) )
    val fixedMid = mid( (0,100) )
    println( fixedMid(200) )
    println( fixedMid(2) )
    @@( "Hello" )()
    @@( "abc" )(4)
    @@()(2) // twice the empty line
    @@( "abc" )()
    def add_<( arg: String ) = "<"+arg
    def add_>( arg: String ) = arg+">"
    val wrap = compose2( add_<, add_>)
    println( wrap( "hello") )
  }
}

// output
//3
//5
//8
//100
//2
//Hello
//abc
//abc
//abc
//abc


//abc
//<hello>
