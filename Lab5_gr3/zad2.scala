package Lab5_gr3

object zad2 {



  def main(args: Array[String]): Unit = {

    var Max = 0
    var actual = 0

    def upTo(i: Int)(fun: => Int): Int = {
      Max = i
      fun
    }
    def calc(i: => Int)(j: => Unit): Int ={
      val temp = i
      if(actual + temp > Max) return actual else { actual += temp; j}
      actual
    }


    val totSum = 5
    val result = upTo(7) {
      calc{ println("start with 2"); 2 } {
        calc{ println(" then one"); 1 }{
          calc { println("  adding more")
            val x = totSum -4+1; x } {
            calc{ println("   even more to add"); 4 }{
              calc{ println("    adding final "); 1 }()
            }
          }
        }
      }
    }
    println( result )
    /* expected
    start with 2
    then one
      adding more
       even more to add
    5
    */
  }
}
