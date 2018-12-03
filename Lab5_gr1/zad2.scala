package Lab5_gr1
import scala.annotation.tailrec
import scala.math.sqrt
import scala.math.pow
import scala.math.abs

object zad2 {

  class MapPoint(val name: String, val lat: Double, val long: Double){

    private def NS(): String = if(this.lat > 0) "N " else "S "
    private def EW(): String = if(this.long > 0) "E " else "W "

    def -(town: MapPoint) : Double = sqrt(pow(this.long - town.long, 2) + pow(this.lat - town.lat,2))

    override def toString: String =
          this.name + " " + abs(this.lat).toString + NS + abs(this.long).toString + EW


    def distanceTo(town: MapPoint): Double = {
      this - town
    }

    def move(x: Double, y: Double): MapPoint = new MapPoint("Nearby " + this.name, this.lat + x, this.long + y)


  }

  object MapPoint{
    def apply(name: String,lat: Double,long: Double): MapPoint = new MapPoint(name ,lat, long)
  }



  class Route(var rode: List[MapPoint]){
   override def toString: String = {

      @tailrec def help(list: List[MapPoint], result: String = ""): String =
        if(list.tail.isEmpty) result + list.head.toString else help(list.tail, result +   list.head.toString + "-> ")

     help(this.rode)
   }

    def addStop(stop: MapPoint): Unit = rode = stop :: rode
  }

  object Route{
    def apply( start: MapPoint, stop: MapPoint, last: MapPoint): Route = new Route(List(last, stop, start))
  }


  def main(args: Array[String]): Unit = {
    val krk = MapPoint( "Krakow", 50.061389, 19.938333 )
    println( krk )
    val nyc = MapPoint( "NYC", 40.7127, -74.0059 )
    println( nyc )
    val porto = MapPoint( "Porto", 41.162142, -8.621953 )
    val irkutsk = MapPoint( "Irkutsk",  52.283333, 104.283333 )
    println( irkutsk )
    println( porto - irkutsk ) // calculates straight line distance
    println( krk - irkutsk )
    println( krk.distanceTo(porto) )
    val r = Route( krk, nyc, porto )
    println( r ); // observe printing order, hints the container used
    r.addStop( porto.move( 1, 1 ) )
    r.addStop( irkutsk )
    println( r )
  }
}

//Krakow 50.061389N 19.938333E
//NYC 40.7127N 74.0059W
//Irkutsk 52.283333N 104.283333E
//113.45168353092112
//84.37426183463258
//29.914654160942675
//Porto 41.162142N 8.621953W -> NYC 40.7127N 74.0059W -> Krakow
//50.061389N 19.938333E
//Irkutsk 52.283333N 104.283333E -> Nearby Porto 42.162142N
//7.6219529999999995W -> Porto 41.162142N 8.621953W -> NYC
//40.7127N 74.0059W -> Krakow 50.061389N 19.938333E