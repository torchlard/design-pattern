package frdomain.ch5
package domain
package service

import java.util.Date
import scalaz._
import Scalaz._
import Kleisli._
import \/._

import repository.AccountRepository


sealed trait AccountType
case object Checking extends AccountType
case object Savings extends AccountType

// trait: module definition ; AccountService: module name ; [..]: parameterized on types
trait AccountService[Account, Amount, Balance] {
  // type: domain friendly type aliases ; AccountRepository: explicit collaboration with other patterns
  type Valid[A] = NonEmptyList[String] \/ A
  type AccountOperation[A] = Kleisli[Valid, AccountRepository, A]

  def open(no: String, name: String, rate: Option[BigDecimal], openingDate: Option[Date], 
    accountType: AccountType): AccountOperation[Account]

  def close(no: String, closeDate: Option[Date]): AccountOperation[Account]

  def debit(no: String, amount: Amount): AccountOperation[Account]

  def credit(no: String, amount: Amount): AccountOperation[Account]

  def balance(no: String): AccountOperation[Balance]

  // transfer defined as composition of other operations
  def transfer(from: String, to: String, amount: Amount): AccountOperation[(Account, Account)] 
    = for { 
      a <- debit(from, amount)
      b <- credit(to, amount)
    } yield ((a, b))
}

