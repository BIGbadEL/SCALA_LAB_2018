package Lab8_gr2

object zad1 {

  abstract class Pizza{
    def name: String
    def price: Double
  }

  trait TomatoSauce extends Pizza{
    abstract override def name: String =  "TomatoSauce" + super.name
    abstract override def price: Double = 1 + super.price
  }

  trait Mozarella extends Pizza{
    abstract override def name: String =  "Mozarella " + super.name
    abstract override def price: Double = 2.0 + super.price
  }

  trait Ham extends Pizza{
    abstract override def name: String =  "Ham " + super.name
    abstract override def price: Double = 8.0 + super.price
  }

  trait Mushroms extends Pizza{
    abstract override def name: String =  "Mushroms " + super.name
    abstract override def price: Double = 4.0 + super.price
  }

  class ThinDough extends Pizza{
    override def name = "on Thin dogh "
    override def price = 8.0
  }



  def main(args: Array[String]): Unit = {
    val myPizza = new ThinDough with TomatoSauce with Mozarella with Ham
    println( myPizza.name + myPizza.price )
    val yourPizza = new ThinDough with TomatoSauce with Mozarella with Mushroms
    println( yourPizza.name + yourPizza.price )
    /*
    Ham  Mozarella  Tomato Sauce  on thin dough 14.0
    Mozarella  Mozarella  Tomato Sauce  on thin dough 14.5
    */
  }

}
