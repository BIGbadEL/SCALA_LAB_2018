package Lab7_gr3

object zad2 {
  class Point{
    var x,y = 0
    override def toString: String = "(" + x.toString + "," + y.toString + ")"
    def moveX(v: Int): Unit = x += v
    def moveY(v: Int): Unit = y += v
  }


  trait LimitX{
    var min: Int = Int.MinValue
    var max: Int = Int.MaxValue
  }

  trait Moves extends Point{
    var min: Int
    var max: Int


    def left: Moves = {
      if(x-1 >= min) moveX(-1)
      this
    }

    def right: Moves = {
      if(x+1 <= max) moveX(1)
      this
    }

    def up: Moves = {
      if(y+1 <= max) moveY(1)
      this
    }

    def down: Moves = {
      if(y-1 >= min) moveY(-1)
      this
    }


  }

  def main(args: Array[String]): Unit = {
    val x = new Point with LimitX with Moves
    x.min = -2
    x.max = 2
    x.left.left.up.up.up.left
    x.right.down.right.down.right.down.right.down
    println(x)
  }
}
