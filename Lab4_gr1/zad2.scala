package Lab4_gr1


object zad2 {

  def main(args: Array[String]): Unit = {

      var y = 0
      def saved = y
      def save(f: => Int) {
        y = f
      }


    save{ val z = 90; println("some message"); (z+1)*z }

    val x = saved
    println( x )
    save{ val a = "hello"; a.length }
    println( "" + saved )
  }
}


//8190
//5