package Lab8_gr1

object zad2 {
  class Person(val name: String, val fname: String, val age: String){
    override def toString: String = "Person(" + name + ", " + fname + ", " + age + ")"
  }

  class Company(val name: String, val origin: String){
    override def toString: String = "Company(" + name + "," + origin + ")"
  }

  class Diword(val str: String, val str2: String){
    override def toString: String = "Diword(" + str + "," + str2 + ")"
  }


  def extr(list: List[Any]): List[Any] ={
    list.map {
      case map: Map[String, String] =>
        if (map.contains("name")) new Person(map("name"), map("fname"), map("age"))
        else if (map.contains("company")) new Company(map("company"), map("origin"))
      case list: List[String] =>
        new Diword(list.head, list.tail.head)
    }
  }

  def onlyPeople(list: List[Any]): List[Person] = {
    list.filter(_.isInstanceOf[Person]).asInstanceOf[List[Person]]
  }

  def onlyComp(list: List[Any]): List[Company] = {
    list.filter(_.isInstanceOf[Company]).asInstanceOf[List[Company]]
  }


  def main(args: Array[String]): Unit = {

    val data = List( Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
      Map("company" -> "ABB", "origin" -> "Sweden"),
      Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),
      Map("company" -> "F4", "origin" -> "Poland"),
      List("Cos", "innego"),
      Map("company" -> "Salina Bochnia", "origin" -> "Poland"),
      Map("company" -> "AGH", "origin" -> "Poland"),
      Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14")
    )

    val p = extr(data)

    println(p)
    println(onlyPeople(p))
    println(onlyComp(p))


  }

}

/* wynik
 List(Person(Jan,Kowalski,45), Company(ABB,Sweden), Person(Katarzyna,Nowak,45), Company(F4,Poland), DiWord(Cos,innego),
Company(Salina Bochnia,Poland), Company(AGH,Poland), Person(Krzysztof,Krol,14))
List(Person(Jan,Kowalski,45), Person(Katarzyna,Nowak,45), Person(Krzysztof,Krol,14))
List(Company(ABB,Sweden), Company(F4,Poland), Company(Salina Bochnia,Poland), Company(AGH,Poland))
 */