package Lab8_gr3

import scala.language.implicitConversions

object zad1 {

  class MyString(val content: String){
    override def toString: String = content
    def wrap(prefix: String, suffix: String): String = content
    def transform(function: String => String): String = content
  }


  trait Wrap extends MyString{
    var prefix = ""
    var suffix = ""
    override def wrap(pref: String, suf: String): String = {
      prefix = pref
      suffix = suf
      prefix + content + suffix
    }

    override def toString: String = prefix + content + suffix
  }



  trait Transform extends MyString {

    var fun: String => String = (str: String) => str

    override def transform(function: String => String): String ={
      fun = function
      function(content)
    }

    override def toString: String = fun(super.toString)

  }

  def main(args: Array[String]): Unit = {

    val s1 = new MyString("Hello") with Wrap wrap(">>", "<<")
    println(s1)

    val s2 = new MyString("There")  with Transform transform(
      _.toLowerCase )
    println(s2)


    case class SpacedWord( str: String ) extends MyString ( str ) with Wrap with Transform {
      wrap("/", "/")
      transform( _.toUpperCase )
    }

    implicit def toSpacedWord(str: String): SpacedWord = SpacedWord(str)

    val w = List[SpacedWord]( "you", "manage", "it", "easily" )
    println( w.mkString("") )


  }


}
/* expected result
>>Hello<<
there
*/
/* expected result
/YOU//MANAGE//IT//EASILY/

*/
