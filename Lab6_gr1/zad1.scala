package Lab6_gr1

object zad1 {

  class Expense(val amount: Int, val description: String){
    def +(ex: Expense): Expense = new Expense(this.amount + ex.amount, this.description + " and " + ex.description)

    override def toString: String =  description + " - " +  amount.toString + " zl"
  }

  object Expense{
    def apply(amount: Int ,description: String): Expense = new Expense( amount , description)
  }

  class Income(val amount: Int, val description: String, val data: String){
    override def toString: String = data + " - " + description + " - " + amount.toString + " zl"
  }
  object Income{
    def apply(amount: Int, description: String, data: String): Income = new Income(amount, description, data)
  }

  class Bookkeeping(var expenses: List[Expense] = List(), var incomes: List[Income] = List(), var balance: Int = 0){
    def -=(ex: Expense): Unit = {expenses  = expenses ++ List(ex); balance -= ex.amount}
    def +=(in: Income): Unit = {incomes = incomes ++ List(in); balance += in.amount; }

    def print(): Unit = {
      expenses.foreach(println(_))
      incomes.foreach(println(_))
      println(s"balance: $balance zl")
    }

  }




  def main(args: Array[String]): Unit = {
    val e = Expense(10,"cinema ticket") + Expense(10,"popcorn")
    val bk = new Bookkeeping()
    bk -= Expense(20, "lunch")
    bk -= Expense(200, "jacket")
    bk += Income(1000, "subsistence", "10 December")
    bk -= e
    bk.print()
  }

}
