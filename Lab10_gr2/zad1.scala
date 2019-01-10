package Lab10_gr2



object zad1 extends App {

  trait Food{
    var nazwa: String = ""
  }

  trait meatFood extends Food{}
  trait plantFood extends Food{}

  class Grass extends plantFood {
    nazwa = "Grass"
  }

  class Hay extends plantFood {
    nazwa = "Hay"
  }

  abstract class Animal(val name: String){
    type canEat <: Food
    def eat(f: canEat): Unit
  }

  class Cow(name: String) extends Animal(name) with meatFood{
    nazwa = name
    type canEat = plantFood
    override def eat(f: canEat): Unit = println(name + " eats " + f.nazwa)

  }

  class Woolf(name: String) extends Animal(name) {
    type canEat = Cow
    def eat(f: canEat): Unit = println(name + " eats " + f.nazwa)
  }




      val g = new Grass
      val h = new Hay
      val c1 = new Cow("ANiceCow")
      val c2 = new Cow("MilkyCow")
      val w1 = new Woolf("CowEaterBeast")
//       w1.eat(g)// has to fail compilation
      c1.eat( g )
      c2.eat( h )
//       c1.eat( c1 ); // has to fail compilation
      w1.eat( c1 )
      // expected output
      // Cow ANiceCow eats Grass
      // Cow MilkyCow eats Hay
      // Woolf CowEaterBeast eats Cow ANiceCow



}
