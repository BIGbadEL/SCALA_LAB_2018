package Lab6_gr2

import scala.annotation.tailrec

object zad1 {

  @tailrec def forel(ints: List[Int], result: Int = 0)(con: Int => Boolean)(exe: => Unit)(fail: => Unit): Int = {
    if(ints.isEmpty)   result; else if(con(ints.head)){
      exe
      forel(ints.tail,result + 1)(con)(exe)(fail)
    }else{
      fail
      forel(ints.tail,result)(con)(exe)(fail)
    }
  }

  def main(args: Array[String]): Unit = {

    val li = List(1,4,3,4,52,3,2)
    val npos1 = forel( li )( _<5){
      println("<3")
    }{
      println(" not <3 ")
    }
    println(npos1)
    val npos2 = forel( li )( _%3 == 0 ){
      println("divisble by 3")
    }{
      println(" not divisible 3")
    }
    println(npos2)


  }
}


// expected result
//<3
//<3
//<3
//<3
//not <3
//<3
//<3
//6
//not divisible 3
//not divisible 3
//divisble by 3
//not divisible 3
//not divisible 3
//divisble by 3
//not divisible 3
//2