/** Base abstraction */
sealed trait TransactionType
case class CR extends TransactionType
case class DR extends TransactionType

sealed trait Currency
case class AUD extends Currency
case class USD extends Currency
case class JPY extends Currency
case class IDR extends Currency

case class Money(m: Map[Currency, BigDecimal]) {
  def toBaseCurrency: BigDecimal = //...
}

case class Transaction(txid: String, accountNo: String, date: Date,
  amount: Money, txnType: TransactionType, status: Boolean)

case class Balance(b: Money)

/** implementation */
trait Analytics[Transaction, Balance, Money] {
  def maxDebitOnDay(txns: List[Transaction]): Money
  def sumBalances(bs: List[Transaction]): Money
}

object Analytics extends Analytics[Transaction, Balance, Money] {
  def maxDebitOnDay(txns: List[Transaction]): Money = {
    txns.filter(_.txnType == DR).foldLeft(zeroMoney) {
      (a, txn) => if(gt(txn.amount, a)) valueOf(yxn) else a
    }
  }
  def sumBalances(balances: List[Balance]): Money = {
    balances.foldLeft(zeroMoney) {(a,b) => a + creditBalance(b)}    
  }

  private def valueOf(txn: Transaction): Money = //...
  private def creditBalance(b: Balance): Money = //...
}

/** define Monoid[Map[K,V]] */
final val zeroMoney: Money = Money( Monoid[Map[Currency, BigDecimal]].zero )

implicit def MoneyAdditionMonoid = new Monoid[Money] {
  val m = implicitly[Monoid[Map[Currency, BigDecimal]]]
  def zero = zeroMoney 
  def op(m1: Money, m2: Money) = Money(m.op(m1.m, m2.m))
}

/** redefine operation using monoid */
trait Analytics[Transaction, Balance, Money] {
  def maxDebitOnDay(txns: List[Transaction]) (implicit m: Monoid[Money]): Money
  def sumBalances(bs: List[Transaction]) (implicit m: Monoid[Money]): Money
}

object Analytics extends Analytics[Transaction, Balance, Money] {
  def maxDebitOnDay(txns: List[Transaction]) (implicit m: Monoid[Money]): Money = {
    txns.filter(_.txnType == DR).foldLeft(m.zero) {
      (a, txn) => m.op(a, valueOf(txn))
    }
  }
  def sumBalances(balances: List[Balance]) (implicit m: Monoid[Money]): Money = {
    balances.foldLeft(m.zero) { (a, bal) => m.op(a, creditBalance(bal)) }
  }

  private def valueOf(txn: Transaction): Money = //...
  private def creditBalance(b: Balance): Money = //...
}

/** abstract over context */
trait Foldable[F[_]] {
  def foldl[A,B](as: F[A], z: B, f: (B,A) => B): B
  def foldMap[A,B](as: F[A])(f: A=>B)(implicit m: Monoid[B]): B
    = foldl(as, m.zero, (b: B, a: A) => m.op(b, f(a)))
}

def mapReduce[F[_], A, B](as: F[A]) (f: A=>B) (implicit fd: Foldable[F], m: Monoid[B]) 
  = fd.foldMap(as)(f)

object Analytics extends Analytics[Transaction, Balance, Money] {
  def maxDebitOnDay(yxns: List[Transaction]) (implicit m: Monoid[Money]): Money
    = mapReduce(txns.filter(_.txnType == DR))(valueOf)    // (input data list)(funciton to map)

  def sumBalances(bs: List[Balance])(implicit m: Monoid[Money]): Money 
    = mapReduce(bs)(creditBalance)
  // ...
}
















