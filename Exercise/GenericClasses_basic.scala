package Exercise

object GenericClasses_basic extends App {

  class Container[T](val value: T){
    def get = value
    def Print{ println(value) }
  }

  val z: Container[Int] = new Container[Int](9)
  z.Print
  val x = new Container(z.get)
  val y = new Container("Type of T = String")
  x.Print
  y.Print
  val f = new Container[Float](2)
  f.Print

}
