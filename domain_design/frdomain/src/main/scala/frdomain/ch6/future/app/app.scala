package frdomain.ch6
package future
package app

import scalaz._
import Scalaz._
import Kleisli._
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global

import service.interpreter.PortfolioService
import repository.interpreter.AccountRepositoryInMemory
import model._
import common._

object Main {

  import PortfolioService._

  val accountNo = "a-123"
  val asOf = today

  val ccyPF: Future[Seq[Balance]] = getCurrencyPortfolio(accountNo, asOf)(AccountRepositoryInMemory)
  val eqtPF: Future[Seq[Balance]] = getEquityPortfolio(accountNo, asOf)(AccountRepositoryInMemory)
  val fixPF: Future[Seq[Balance]] = getFixedIncomePortfolio(accountNo, asOf)(AccountRepositoryInMemory)

  // make composite portfolio, each of ccyPF,eqtPF,fixPF is a Future[Seq[Balance]]
  val portfolio: Future[Portfolio] = for {
    c <- ccyPF
    e <- eqtPF
    f <- fixPF
  } yield CustomerPortfolio(accountNo, asOf, c ++ e ++ f)

  // val y = Await.result(portfolio, 30 seconds)

// ========= Task version =========
  val ccyPF: Task[Seq[Balance]] = ..
  val eqtPF: Task[Seq[Balance]] = ..
  val fixPF: Task[Seq[Balance]] = ..

  val r = Task.gatherUnordered(Seq(ccyPF, eqtPF, fixPF))
  val portfolio = CustomerPortfolio(accountNo, asOf, 
    r.run.foldLeft(List.empty[Balance])(_ ++ _))

}

