package Lab6_gr1

object zad2 {

  abstract class MoneyFlow(val amount: Int, val description: String){
    override def toString: String = description + " -> " + amount.toString + "zl"
  }

  class Expense(amount: Int, description: String) extends MoneyFlow(amount,description){
    def +(ex: Expense): Expense = new Expense(this.amount + ex.amount, this.description + " and " + ex.description)
  }

  object Expense{
    def apply(amount: Int ,description: String): Expense = new Expense( amount , description)
  }

  class Income(amount: Int,description: String, val data: String) extends MoneyFlow (amount,description){
    override def toString: String = data + " - " + description + " -> " + amount.toString + " zl"
  }
  object Income{
    def apply(amount: Int, description: String, data: String): Income = new Income(amount, description, data)
  }

  class Bookkeeping(var Flow: List[MoneyFlow] = List(), var balance: Int = 0){
    def +=(data: MoneyFlow): Unit = {
      Flow = Flow ++ List(data)
      data match{
        case _: Expense => balance -= data.amount;
        case _: Income => balance += data.amount;
      }
    }

    def print(): Unit = {
      Flow.foreach(println(_))
      println(s"balance: $balance zl")
    }

  }

  def main(args: Array[String]): Unit = {

    val e = Expense(10,"cinema ticket") + Expense(10,"popcorn")
    val bk = new Bookkeeping()
    bk += Expense(20, "lunch")
    bk += Expense(200, "jacket")
    bk += Income(1000, "subsistence", "10 December")
    bk += e
    bk.print()
  }

}
