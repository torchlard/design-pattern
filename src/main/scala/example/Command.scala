import scala.collection.mutable.ArrayBuffer

// object Command extends App {
//   val abcStock = new Stock("abc", 10)
//   val defStock = new Stock("def", 5)
//   val broker = new Broker

//   broker.takeOrder(new BuyStock(abcStock))
//   broker.takeOrder(new BuyStock(defStock))
//   broker.takeOrder(new SellStock(abcStock))

//   broker.placeOrders()

// }

trait Order {
  def execute(): Unit
}

class Stock (name: String, quantity: Int) {
  def buy(): Unit = println(s"Stock [name: $name, quantity: $quantity] bought")
  def sell(): Unit = println(s"Stock [name: $name, quantity: $quantity] sold")
}

class BuyStock(stock: Stock) extends Order {
  def execute() = stock.buy()
}

class SellStock(stock: Stock) extends Order {
  def execute() = stock.sell()
}

class Broker {
  private var orderList: ArrayBuffer[Order] = new ArrayBuffer()

  def takeOrder(order: Order) = orderList.append(order)

  def placeOrders() = {

    for(order <- orderList){
      order.execute()
    }
    orderList.clear()
  }
  
}


