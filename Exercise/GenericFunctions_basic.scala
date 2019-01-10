package Exercise

object GenericFunctions_basic extends App {

  class Type(val name: String, val number: Double){
    override def toString: String = name +  ": " + number.toString
  }

  def test[T](x:T): Unit = {
    println(x)
    println(x.getClass.getSimpleName)
  }

  test(4)
  test(5.223)
  test(new Type("new", 0.0))

}
