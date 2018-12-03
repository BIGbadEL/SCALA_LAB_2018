package Lab7_gr2

import scala.annotation.tailrec

object zad1 {

  class BChar(val letter: List[String] = List()){
    def print(): Unit ={
      letter.foreach(println(_))
      println()
    }

    def comparPlus(x: Char,y: Char) : Char = if(x == '*' || y == '*') '*' else ' '
    def comparMinus(c: Char, c1: Char): Char = if( c == '*' && c1 == '*' ) ' ' else
      if( c == ' ') ' '  else  '*'

    def +(another: BChar): BChar = {
      @tailrec def help(right: List[String], left: List[String], result: List[String] = List()): BChar ={
        if(right.isEmpty) new BChar(result) else {
          var temp = ""
          for(x <- 0 until 5) temp = temp + comparPlus(right.head.charAt(x), left.head.charAt(x))
          help(right.tail, left.tail, result ++ List(temp))
        }
      }
      help(letter, another.letter)
    }

    def -(another: BChar): BChar = {
      @tailrec def help(right: List[String], left: List[String], result: List[String] = List()): BChar ={
        if(right.isEmpty) new BChar(result) else {
          var temp = ""
          for(x <- 0 until 5) temp = temp + comparMinus(right.head.charAt(x), left.head.charAt(x))
          help(right.tail, left.tail, result ++ List(temp))
        }
      }
      help(letter, another.letter)
    }

  }

  object BChar{
    def apply(char: String): BChar = {
      char match{
        case "A" => new BChar(List(" *** ", "*   *", "*****", "*   *", "*   *"));
        case "B" => BChar("A") + new BChar(List("*     ","     ","     ","     "," *** "));
        case "C" => new BChar(List("*****","*    ","*    ","*    ","*****"))
        case "G" => BChar("B") - new BChar(List("     ", "    *", " **  ", "     ", "     "));
        case "I" => new BChar(List("  *  ", "  *  ", "  *  ", "  *  ", "  *  "));
        case "Z" => new BChar(List("*****", "   * ", "  *  ", " *   ", "*****"));
        case "R" => BChar("A") - new BChar(List("     ", "     ", "    *", "    *", " *** ")) + new BChar(List("*     ", "     ", "     *", "  *  ", "     "))
        case "E" => BChar("C") + new BChar(List("     ","     ", "*****","     ","     "))
        case "O" => BChar("C") + new BChar(List("    *","    *","    *","    *","    *"))
      }

    }
    def A: BChar = BChar("A")
  }

  def printString(string: BChar*): Unit={
    for(i <- 0 until 5){
      for(x <- string){
        print(x.letter(i))
        print("   ")
      }
      println()
    }
  }

  def main(args: Array[String]): Unit = {
    val G = BChar("G")
    val R = BChar("R")
    val Z = BChar("Z")
    val E = BChar("E")
    val O = BChar("O")

    printString(G,R,Z,E,G,O,R,Z)


  }

}
