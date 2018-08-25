// naive approach, too verbose, lack of compositionality
trait AccountService[Account, Amount, Balance]{
  def open(no: String, name: String, openDate: Option[Date], r: AccountRepository): Try[Account]
  def close(no: String, closeDate: Option[Date], r: AccountRepository): Try[Account]
  ...
}

object App extends AccountService {
  def op(no: String, aRepo: AccountRepository) = for {
    _ <- credit(no, BigDecimal(100), aRepo)
    _ <- credit(no, BigDecimal(300), aRepo)
    _ <- credit(no, BigDecimal(160), aRepo)
    b <- balance(no, aRepo)
  } yield b
}

// improved, curry approach
trait AccountService[Account, Amount, Balance]{
  def open(no: String, name: String, openDate: Option[Date]): AccountRepository => Try[Account]
  def close(no: String, closeDate: Option[Date]): AccountRepository => Try[Account]
  ...
}

object App {
  import AccountService._
  def op(no: String) = for {
    _ <- credit(no, BigDecimal(100))
    _ <- credit(no, BigDecimal(300))
    _ <- credit(no, BigDecimal(160))
    b <- balance(no)
  } yield b
}

// main
import App._
op("a-123")   // function: AccountRepository => scala.util.Try[Balance]

// can compose with any other computation that returns Funciton1[AccountRepository, _]




