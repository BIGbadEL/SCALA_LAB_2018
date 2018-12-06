package Lab6_gr2


object zad2 {

  class STime(val h: Int, val min: Int, val sec: Int) {
    import Lab6_gr2.zad2.STime.Type._

    def toSec: Int = 3600 * h + 60 * min + sec

    override def toString: String = h.toString + ":" + min.toString + ":" + sec.toString
    def <(time: STime):Boolean = toSec < time.toSec

    def >(time: STime):Boolean = toSec > time.toSec

    def ==(time: STime):Boolean = toSec == time.toSec

    def !=(time: STime):Boolean = !(this == time)

    def moveBy(mv: Int = 0)(par: Type): STime ={
      par match {
        case STime.Type.seconds => new STime(h, min, sec + mv);
        case STime.Type.minutes => new STime(h, min + mv, sec);
        case STime.Type.hour => new STime(h + mv, min, sec)
        case _ => new STime(0,0,0)
      }
    }



  }

  object STime extends Enumeration{
    def apply(h: Int,min: Int,sec: Int): STime = new STime(h, min, sec)
    object Type extends Enumeration{
      type Type = Value

      val hour, minutes, seconds = Value
    }
  }



  def main(args: Array[String]): Unit = {
    val Time = STime(5, 10 , 15)
    val Time1 = STime(5, 10 , 15)
    println(Time)
    println(Time1)
    println(Time1 == Time)
    println(Time1 != Time)

    val t1 = Time1.moveBy(10)(STime.Type.seconds)
    println(t1)
    println(t1 > Time)
    println(t1 < Time)



  }

}
