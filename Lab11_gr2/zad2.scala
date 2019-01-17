package Lab11_gr2



object zad2 extends App{
  val in = List(List(1, 2, 3, 4),
                List(5, 0, -1, 7),
                List(-1, 51, 1, 0),
                List(0, 0, 7, 7))

  println(in.maxBy(_.max).max)

  println(in.maxBy(_.max))

  println(in.map(_.reduce((x1,x2) => if (x1 > x2) x1 else x2)))

  def indicate(list: List[List[Int]], fun: PartialFunction[Int, Boolean]): List[Boolean] = {
    list.map(_.collect(fun)).filter(_.nonEmpty).flatten
  }

  println( indicate( in, {case x if x < 0 => true} ) ) // List(true, true) // two negative values

  def synchForEach[T](list: List[List[Int]],fun: List[Int] => T): List[T] = {

    list.transpose.map(fun)

  }

  println( synchForEach( in, { x => x } ) ) // List(List(1, 5, -1, 0), List(2, 0, 51, 0), List(3, -1, 1, 7), List(4, 7, 0,7)) // transposition
  println( synchForEach( in, { x => x.max } )) // List(5, 51, 7, 7) // max in each “column”
}


//.reduce((x1,x2) => if (x1 > x2) x1 else x2))