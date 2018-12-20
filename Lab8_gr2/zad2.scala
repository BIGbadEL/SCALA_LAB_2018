package Lab8_gr2

import java.io.Serializable

import scala.annotation.tailrec

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

  @tailrec def extr(list:  List[Iterable[Serializable] with PartialFunction[Int with String,String]],
           result: List[Any] = List()): List[Any] ={
    if(list.isEmpty) result else{
      list.head match {
        case temp: Map[String, String] => list.head.head match {
          case ("name", _) => extr(list.tail, new Person(temp("name"), temp("fname"), temp("age")) :: result)
          case ("company", _) => extr(list.tail, new Company(temp("company"), temp("origin")) :: result)
          case _ => extr(list.tail, result)
        }
        case temp: List[String] => extr(list.tail, new Diword(temp.head, temp.tail.head) :: result)
      }
      //extr(list.tail, result)
    }
  }

  @tailrec def onlyPeople(list: List[Any], result: List[Person] = List()): List[Person] = {
    if(list.isEmpty) result else {
      list.head match {
        case temp: Person => onlyPeople(list.tail, temp :: result)
        case _ => onlyPeople(list.tail, result)
      }
    }
  }

  @tailrec def onlyComp(list: List[Any], result: List[Company] = List()): List[Company] ={
    if(list.isEmpty) result else {
      list.head match {
        case temp: Company => onlyComp(list.tail, temp :: result)
        case _ => onlyComp(list.tail, result)
      }
    }
  }

  def main(args: Array[String]): Unit = {

    val data = List(Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
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


  /* wynik
   List(Person(Jan,Kowalski,45), Company(ABB,Sweden), Person(Katarzyna,Nowak,45), Company(F4,Poland), DiWord(Cos,innego),
Company(Salina Bochnia,Poland), Company(AGH,Poland), Person(Krzysztof,Krol,14))
List(Person(Jan,Kowalski,45), Person(Katarzyna,Nowak,45), Person(Krzysztof,Krol,14))
List(Company(ABB,Sweden), Company(F4,Poland), Company(Salina Bochnia,Poland), Company(AGH,Poland))
   */

}
