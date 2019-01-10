package Lab11_gr2

import scala.concurrent.Future
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.Random

object zad1 extends App {

  def psearch(str: Vector[Char], char: Char): Future[Boolean] = {
    val str_split = str.grouped(str.length / 10)
    val futures = str_split.map(x => Future{
      x.contains(char)
    })
    Future.sequence(futures) map {
      _.contains(true)
    }
  }

  val x = Random.alphanumeric
  val rstr = (x take 100).toVector
  println(rstr)
  val found = psearch( rstr, 'x')
  found onSuccess {
    case f => println("found " + f )
  }

  Await.ready( found , Duration(10, SECONDS))

}
