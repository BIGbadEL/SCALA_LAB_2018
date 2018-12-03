package Lab7_gr1

object zad1 {
  import java.util.Calendar

  class Logger{
    def pprint(str: String): Unit = print(str)

  }

  trait Quote extends Logger{
    override def pprint(str: String): Unit = print( "\"" + str+ "\"")
  }

  trait TimeStamp extends Logger{
    abstract override def pprint(str: String): Unit ={
      print(Calendar.getInstance().getTime.toString + " ")
      super.pprint(str)
    }
  }



  def main(args: Array[String]): Unit = {

    val l = new Logger with Quote with TimeStamp
    l.pprint("Hello world")
    println("")

    val ql = new Logger with Quote
    ql.pprint("No date, just quote")
    println("")
    val tl = new Logger with TimeStamp
    tl.pprint("Some time stamped message")
    println("")
    val plain = new Logger
    plain.pprint("Just the text")
    println("")



  }

}
