package Lab7_gr1

object zad2 {

  implicit def toArray(x: Int): Array[Int] = Array.ofDim[Int](x)


  object Int{
   def *(x: Int): Array[Int] = x
  }



  class sfType(val a:Int = 0){}

  def main(args: Array[String]): Unit = {


    val x = Int*5
    println( x.getClass.getSimpleName + x.mkString(" ") )
    // expected output  int[]0 0 0 0 0


  }

}
