package frdomain.ch4
package trading

import scalaz._
import Scalaz._

trait Trading[Account, Trade, ClientOrder, Order, Execution, Market] {

  // 3 operations lead from client order to trade
  // Kleisli is just wrapper for A => M[B] to compose monads; List is an effect
  // Kleisli[M[_], A, B]    M = monad used, A = initial type, B = ending type
  def clientOrders: Kleisli[List, List[ClientOrder], Order] // List[ClientOrder] => Order
  def execute(market: Market, brokerAccount: Account): Kleisli[List, Order, Execution]
  def allocate(accounts: List[Account]): Kleisli[List, Execution, Trade]
  
  // define order of operations
  def tradeGeneration(market: Market, broker: Account, clientAccounts: List[Account]) = {
    clientOrders               andThen    // andThen is opposite of compose
    execute(market, broker)    andThen   
    allocate(clientAccounts)
  }
}
