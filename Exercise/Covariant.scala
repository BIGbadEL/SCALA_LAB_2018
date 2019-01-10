package Exercise

object Covariant extends App {

  class Container[+T](val value: T){
    def get = value
    def set[X](nv: X): Container[X] = { new Container[X](nv) }
    def Print = { println(value) }
  }

  val i: Container[Int] = new Container[Int](10)
  val a: Container[Any] = i
  a.Print
  a.set("string").Print
  i.Print

//  class Container2[-T](var value: T){
//    def get() = value
//  }

  class Container3[+T](val v:T) {
    def get = v
  }

  class A() {}
  case class B() extends A {}

    var x = new Container[A](new A())
    val y = new Container[B](new B())
    x = y // the covariance at work

}
