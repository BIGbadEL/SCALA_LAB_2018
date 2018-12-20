package Lab8_gr3



object zad2 {
  abstract class ServerEvent

  case class NewCon(name: String) extends ServerEvent
  case class Request(name: String, path: String) extends ServerEvent
  case class Drop(name: String) extends ServerEvent

  class Server{
    var connection_list: List[ServerEvent] = List.empty
    def <<(event: ServerEvent): Server = {
      event match {
        case temp: NewCon =>
          println(s"new connection from agent: ${temp.name}")
          connection_list = temp :: connection_list
        case temp: Drop =>
          println(s"drop connection from agent: ${temp.name}")
          connection_list = connection_list.filter( _ != NewCon(temp.name))
        case temp: Request if connection_list.contains( NewCon(temp.name))=>
          println(s"serving resource file:: ${temp.path} to agent ${temp.name}")
        case temp: Request => println(s"ERROR: Unknown agent ${temp.name} , not serving: ${temp.path}")
      }
      this
    }
  }

  def main(args: Array[String]): Unit = {

    val s = new Server
    s << NewCon("Agent1") << Drop("Agent1")
    //println(s.connection_list)
    s << Request( "Agent1", "file::/home/data" )
    s << NewCon("Agent1") << Request( "Agent1", "file::/home/data" )
    s << NewCon("Agent1") << Request( "Agent1", "file::/home/data" )
    s << NewCon("Agent007") << Request( "Agent1", "file::/home/data" ) << Request("Agent007", "Life")
    s << Drop("Agent007") << Drop("Agent1")
    //println(s.connection_list)
  }
}





    // expect result
//    new connection from agent: Agent1
//    drop connection from agent: Agent1
//    ERROR: Unknown agent Agent1 , not serving: file::/home/data
//    new connection from agent: Agent1
//    serving resource file::/home/data to agent Agent1
//    new connection from agent: Agent1
//    serving resource file::/home/data to agent Agent1
//    new connection from agent: Agent007
//    serving resource file::/home/data to agent Agent1
//    serving resourceLife to agent Agent007
//    drop connection from agent: Agent007
//    drop connection from agent: Agent1
//
