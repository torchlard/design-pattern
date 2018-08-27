type AccountNo = String
type Balances = Map[AccountNo, Balance]
val balances: Balances = //...

case class Transaction(accountNo: AccountNo, amount: Money, date: Date)
val txns: List[Transaction] = //...

import Monoid._
import scalaz.State
import State._

// Banace is monoid
// State monad is function from (S) => (A,S) ; State is Map[AccountNo, Balance]
def updateBalance(txns: List[Transaction]): State[Balances, Unit] = 
  modify {
    (b: Balances) => txns.foldLeft(b) {
      (a, txn) => implicitly[Monoid[Balance]]
        .op( a.Map(txn.accountNo -> Balance(txn.amount)) )
    }
  }

// run updateBalance on list of transactions
updateBalance(txns) run balances

// StateT: monad transformer
val StateGen = StateT.stateMonad[Generator]
import StateGen._
val r: AccountRepository = //...
// gets: apply transformation function, return updated State monad
// modify: accept function, modify state
val s = whileM_(gets(_.exists), modify(_ => new Generator(r)))
val start = new Generator(r)
s exec start

ValidationNel[String, Account]











