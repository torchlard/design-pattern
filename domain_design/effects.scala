trait Functor[F[_]] {
  def map[A,B](a: F[A])(f: A=>B): F[B]
}

def ListFunctor: Functor[List] = new Functor[List] {
  def map[A,B](a: List[A])(f: A => B): List[B] = a map f
}

def OptionFunctor: Functor[Option] = new Functor[Option] {
  def map[A,B](a: Option[A]) (f: A=>B): Option[B] = a map f
}

trait Account {
  def accountsOpenedBefore(date: Date): List[Account] = ???
  def accountFor(no: String): Option[Account] = ???
  def close(a: Account): Account = ???

  def calcInterest(date: Date) = accountsOpenedBefore(dt).map(interestOn)
  def calcInterest(no: String) = accountFor(no).map(interestOn)
}

/** being parametric */
def calcInterest(dt: Date) = fmap(accountsOpenedBefore(dt))(interestOn)
def calcInterest(no: String) = fmap(accountFor(no))(interestOn)
def closeAccount(no: String) = fmap(accountFor(no))(close)

/** Applicative Functor */
// f: A=>B lifted into context of F, transform F[A] -> F[B]

def savingsAccount(no: String, name: String, rate: BigDecimal, openDate: Option[Date])
  : Try[Account] = {
    closeDateCheck(openDate, closeDate).map { d =>
      if (rate <= BigDecimal(0))
        throw new Exception(..)
      else
        savingsAccount(..)
    }
}

type V[A] = Validation[String, A]

def validateAccountNo(no: String): V[String]
def validateOpenCloseDate(openDate: Option[Date], closeDate: Opton[Date]): V[(Date, Option[Date])]
def validateRateOfInterest(rate: BigDecimal): V[BigDecimal]

def apply3 [V[_], A, B, C, D] (va: V[A], vb: V[B], vc: V[C]) // input context
  (f: (A,B,C) => D): V[D]   // process funciton + validated outptu in same context
// lift prue funciton f into context V
def lift3 [V[_], A,B,C,D] (f: (A,B,C)=>D) : (V[A], V[B], V[C]) => V[D] = apply3(_,_,_)(f)

def savingsAccount(no: String, name: String, rate: BigDecimal, openDate: Option[Date],
  closeDate: Option[Date], balance: Balance): V[Account] = {
    apply3(
      validateAccountNo(no),
      validateOpenCloseDate(openDate, closeDate),
      validateRate(rate)
    ) { (n,d,r) => SavingsAccount(n, name, r, d._1, d._2, balance) }
  }

/** applicative trait */
trait Applicative[F[_]] extends Functor[F] {
  def ap[A,B](fa: => F[A])(f: => F[A=>B]): F[B]
  def unit[A](a: => A): F[A]
}
 















