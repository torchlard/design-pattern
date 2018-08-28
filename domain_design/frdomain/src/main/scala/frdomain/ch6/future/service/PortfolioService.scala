package frdomain.ch6
package future
package service

import java.util.Date
import scalaz._
import Scalaz._
import Kleisli._

import scala.language.higherKinds
import repository.AccountRepository
import model._
import scala.concurrent._
import ExecutionContext.Implicits.global

trait PortfolioService {
  // use Kleisli to inject repository
  type PFOperation[A] = Kleisli[Future, AccountRepository, Seq[A]]

// parallel process these 3 functions
  def getCurrencyPortfolio(no: String, asOf: Date): PFOperation[Balance]
  def getEquityPortfolio(no: String, asOf: Date): PFOperation[Balance]
  def getFixedIncomePortfolio(no: String, asOf: Date): PFOperation[Balance]
}


