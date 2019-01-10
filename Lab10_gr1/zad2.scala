package Lab10_gr1

import scala.concurrent.Future
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.Random

object zad2 extends App {

  def psearch(str: Vector[Char], char: Char): Future[Int] = {
    val string = str.grouped(str.length / 10)
    val futures = string.map(x => Future{ x.count(_ == char) })
    Future.sequence(futures) map { ft => ft.sum }
  }



  val x = Random.alphanumeric
  val rstr = (x take 100).toVector
  val found = psearch( rstr, 'x')
  //found.wait()


  found onSuccess {
    case f => println("found " + f)
  }

  Await.ready( found , Duration(10, SECONDS))
}
