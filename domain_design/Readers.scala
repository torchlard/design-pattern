
/** Reader Monad */
case class Reader[R,A](run: R => A) {
  def map[B](f: A=>B): Reader[R,B] = Reader(r => f(run(r)) )

  def flatMap[B](f: A => Reader[R,B]): Reader[R,B] = Reader(r => f(run(r)).run(r) )
}

trait AccountService[Account, Amount, Balance] {
  def open(no: String, name: String, openDate: Option[Date]): Reader[AccountRepository, Try[Account]]
  def close(no: String, closeDate: Option[Date]): Reader[AccountRepository, Try[Account]]
  ...
}


object App extends AccountService {
  def op(no: String) = for {
    _ <- credit(no, BigDecimal(100))
    _ <- credit(no, BigDecimal(300))
    _ <- credit(no, BigDecimal(160))
    b <- balance(no)
  } yield b
}

// main
op("a123").run(AccountRepository)






