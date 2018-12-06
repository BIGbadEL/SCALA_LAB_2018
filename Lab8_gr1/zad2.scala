package Lab8_gr1

import java.io.Serializable

import scala.annotation.tailrec

object zad2 {
  class Person(val name: String, val fname: String, val age: String){
    override def toString: String = "Person(" + name + ", " + fname + ", " + age + ")"
  }

  class Company(val name: String, val origin: String){
    override def toString: String = "Company(" + name + "," + origin + ")"
  }




  def extr(list: List[Iterable[Serializable] with PartialFunction[Int with String,String]]): List[Any] ={
//    val temp: List[Map[String,String]] = list.filter(_.isInstanceOf[Map[String, String]]).asInstanceOf[List[Map[String,String]]]
//    val result = temp.foreach(if()
    List()
  }

  def onlyPeople(list: List[Any]): List[Any] = {
    list.filter(_.isInstanceOf[Person])
  }

  def onlyComp(list: List[Any]): List[Any] = {
    list.filter(_.isInstanceOf[Company])
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