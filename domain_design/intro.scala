import java.util.{Date, Calendar}
import scala.util.{Try, Success, Failure}

object intro {
  type Amount = BigDecimal

  def today = Calendar.getInstance.getTime
  
  case class Balance (amount: Amount=0)

  // /*** Simple Model */
  // // aggregate
  // class Account (val no: String, val name: String, val dateOfOpening: String) {
  //   var balance: Balance = Balance()

  //   // operation that mutable state
  //   def debit(a: Amount) = {
  //     if(balance.amount < a)
  //       throw new Exception("Insufficient balance in account")
  //     balance = Balance(balance.amount -a)
  //   }

  //   // operation that mutable state
  //   def credit (a: Amount) = balance = Balance(balance.amount +a)
  // }

  /** Immutable model */
  class Account(val no: String, val name:String, val dateOfOpening: String, 
    val balance: Balance = Balance()){

      def debit (a: Amount) = {
        if (balance.amount < a)
          throw new Exception("Insufficient balance")
        new Account(no, name, dateOfOpening, Balance(balance.amount-a))
      }

      def credit (a: Amount) = new Account(no, name, dateOfOpening, Balance(balance.amount+a))
    }

  // /** Purified model */
  // // ADT
  // case class Account (no: String, name: String, dateOfOpening: Date, balance: Balance=Balance())
  
  // trait AccountService {
  //   def debit(a: Account, amount: Amount): Try[Account] = {
  //     if (a.balance.amount < amount)
  //       Failure(new Exception("Insufficient balance in account"))
  //     else Success(a.copy(balance = Balance(a.balance.amount - amount)))
  //   }

  //   def credit(a: Account, amount: Amount): Try[Account] = {
  //     Success(a.copy(balance = Balance(a.balance.amount + amount)))
  //   }
  // }

  // // create concrete instance of service 
  // object AccountService extends AccountService
  // import AccountService._



  def main(args: Array[String]): Unit = {

    val a = new Account("a1", "John", "12/2004")
    println(a.balance == Balance(0))

    // // simple model
    // // a.credit(100)
    // // println(a.balance == Balance(100))
    // // a.debit(20)
    // // println(a.balance == Balance(80))

    // immutable model
    val b = a.credit(100)
    println(a.balance == Balance(0))
    println(b.balance == Balance(100))

    val c = b.debit(20)
    println(c.balance == Balance(80))

    // val a = Account("a1", "John", today)
    // println(a.balance == Balance(0))

    // for {
    //   b <- credit(a, 1000)      
    //   c <- debit(b, 200)
    //   d <- debit(c, 190)
    // } yield d

  }
  


}










