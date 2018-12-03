package Lab5_gr1

import scala.annotation.tailrec


object zad1 {


  def main(args: Array[String]): Unit = {


    var x = -5

    @tailrec def repeatUntil(repeat: => Int)(condition: Int => Boolean): Unit ={
       if(condition(repeat)) repeatUntil(repeat)(condition)
    }

    repeatUntil{  x = x +1; println(x); x  }{ _ <= 0  }
    repeatUntil{  x = x -3; println(x); x  }{ _ > -10  }
    repeatUntil{  x = x +7; println(x); x  }{ i:Int => i < 20  }
  }

}

// expected result
//-4
//-3
//-2
//-1
//0
//1
//-2
//-5
//-8
//-11
//-4
//3
//10
//17
//24

