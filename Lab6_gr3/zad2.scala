package Lab6_gr3
import scala.math.Pi
import scala.math.cos
import scala.math.sin
import zad2.Angle.to0_2PI
import zad2.SpaceVector3D.Value
import scala.annotation.tailrec

object zad2 {

  def Round(number: Double): Double = {
    val x = (number * 100).round
     x.toDouble / 100
  }

  class Angle(val angle: Double){
    def *(arg: Double): Angle = Angle(to0_2PI(angle * arg))
    def +(arg: Angle): Angle = Angle(to0_2PI(angle + arg.angle))
    override def toString: String = Round(angle / Pi).toString + " Pi"
  }

  object Angle{
    @tailrec def to0_2PI(ang: Double): Double =
      if(ang >= 0 && ang <= 2 * Pi) ang else if(ang < 0) to0_2PI(ang + 2 * Pi) else to0_2PI(ang - 2 * Pi)

    def apply(angle: Double): Angle = new Angle(to0_2PI(angle))
    def apply(): Angle = new Angle(0)

  }

  class SpaceVector3D(var x: Double, var y: Double, var z: Double){

    override def toString: String = "(" + Round(x).toString + "," + Round(y).toString + "," + Round(z).toString + ")"

    private def Rotx(angle: Angle): Unit ={
      val temp = y
      y = cos(angle.angle) * y - sin(angle.angle) * z
      z = sin(angle.angle) * temp + cos(angle.angle) * z
    }

    private def Roty(angle: Angle): Unit = {
      val temp = x
      x = cos(angle.angle) * x + sin(angle.angle) * z
      z = -temp * sin(angle.angle) + z * cos(angle.angle)
    }

    private def Rotz(angle: Angle): Unit = {
      val temp = x
      x = cos(angle.angle) * x - sin(angle.angle) * y
      y = temp * sin(angle.angle) + y * cos(angle.angle)
    }


    def rot(ang: Angle, axis: Value): SpaceVector3D ={
      axis match {
        case SpaceVector3D.xaxis => Rotx(ang);
        case SpaceVector3D.yaxis => Roty(ang);
        case SpaceVector3D.zaxis => Rotz(ang);
      }
      this
    }
  }

  object SpaceVector3D extends Enumeration {
    val xaxis, yaxis, zaxis = Value
    def apply(x: Double, y: Double, z: Double) = new SpaceVector3D(x,y,z)
  }

  def main(args: Array[String]): Unit = {
    val A1 = Angle(Pi/6 + 20 * Pi)
    val A2 = Angle(Pi)
    val A3 = A1 + A2
    val V1 = SpaceVector3D(1,0,0)
    val V2 = SpaceVector3D(1,0,0)
    println(V1)
    println(V1.rot(A1, SpaceVector3D.yaxis).rot(A2, SpaceVector3D.zaxis))
    println(V2.rot(A2, SpaceVector3D.zaxis).rot(A1, SpaceVector3D.yaxis))

    println(A1)
    println(A2)
    println(A3)
  }

}
