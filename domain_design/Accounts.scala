import java.util.{Date, Calendar}
import util.{Try, Success, Failure}

object Accounts {

  type Amount = BigDecimal
  def today = Calendar.getInstance.getTime

  case class Balance(amount: Amount = 0)

  /** base contract */
  sealed trait Account {
    def no: String
    def name: String
    def dateOfOpen: Option[Date]
    def dateOfClose: Option[Date]
    def balance: Balance
  }

  /** ADT */
  final case class CheckingAccount private (
    no: String, name: String, dateOfOpen: Option[Date],
    dateOfClose: Option[Date], balance: Balance
  ) extends Account
  // final prevent inheritance, private prevent direct instantiation
  final case class SavingsAccount private (
    no: String, name: String, rateOfInterest: Amount, 
    dateOfOpen: Option[Date], dateOfClose: Option[Date], balance: Balance
  ) extends Account

  /** smart constructors */
  def checkingAccount(no: String, name: String, dateOfOpen: Option[Date],
    dateOfClose: Option[Date], balance: Balance): Try[Account] = {
    closeDateCheck (dateOfOpen, dateOfClose).map {
      d => CheckingAccount(no, name, Some(d._1), d._2, balance)
    }
  }
  // use named parameter to make constructor expressive
  def savingsAccount(no: String, name: String, rate: Amount,
    openDate: Option[Date], closeDate: Option[Date], balance: Balance
   ): Try[Account] = {
     closeDateCheck(openDate, closeDate).map { d => 
        if (rate <= BigDecimal(0))    // published API need to be explicit
          throw new Exception(s"Interest rate $rate must be > 0")
        else 
          SavingsAccount(no, name, rate, openDate, closeDate, balance)
     }
  }

  private def closeDateCheck(openDate: Option[Date], closeDate: Option[Date]): 
    Try[(Date, Option[Date])] = {
      val od = openDate.getOrElse(today)

      closeDate.map { cd =>
        if (cd before od) Failure(new Exception("$cd cannot be earlier than $od"))
        else Success((cd, Some(od)) )
        }.getOrElse {
          Success((od, closeDate))
        }
  }

}










