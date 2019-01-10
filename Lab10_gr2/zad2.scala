package Lab10_gr2

object zad2 extends App {

  def fun(str: String): Boolean = {
    str == "John" || str == "Joe"
  }


  val people = List( ("John", "Doe", 23, "male"), ("Joan", "Doe", 23, "female"), ("Steve", "Jenkins", 24, "male"), ("Eva", "Robinson", 25, "female"), ("Ben", "Who", 22, "male"), ("Janet", "Reed", 21, "female"), ("Rob", "Jenkins", 26, "male"), ("Ella", "Dawson", 27, "female") )

  val gender = people.partition(_._4 == "female")
  println(gender._1)
  println(gender._2)

  val names_old = people.filter(_._3 > 23).map( _._1 )
  println(names_old)

  val isJoeOrJohn = people.map(_._1).count(fun) > 0
  println(isJoeOrJohn)

  val isEvAfter20 = people.count( temp => temp._3 > 20) > 0
  println(isEvAfter20)

  val nameAngAge = people.map(temp => (temp._1, temp._3))
  println(nameAngAge)

  val Group = people.groupBy(_._3)
  println(Group)

  val young_old = people.partition(_._3 > 23)

  println(young_old._1)
  println(young_old._2.filter(_._3 < 23))

  val theOldest = people.reduce((value, theBest) => if(value._3 > theBest._3) value else theBest)
  println(theOldest)

  val theYoungest = people.reduce((value, theBest) => if(value._3 < theBest._3) value else theBest)
  println(theYoungest)

  val MaleEqFemale = people.count(temp => temp._4 == "female") == people.length / 2
  println(MaleEqFemale)

  val sortedPeople = people.sortBy(_._3).dropWhile(_._3 <= 23)
  println(sortedPeople)

}
