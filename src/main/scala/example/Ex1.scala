package example

// object Ex1 extends App {
//   val iterator = new IntIterator(5)
//   for (i <- 1 to 10){
//     iterator.next()
//   }
  
//   val writer = new ConsoleWriter with Uppercase
//   writer.print("abc")
// }

trait Iterator[A] {
  def hasNext: Boolean
  def next(): Unit
}

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0
  override def hasNext: Boolean = current < to
  override def next(): Unit = {
    if(hasNext){
      val t = current
      current += 1
      println(t)
    } else {
      current = 0
      println(0)
    }

  }
}

// ==================

abstract class Writer {
  def print(str: String)
}

class ConsoleWriter extends Writer {
  def print(str: String) = println(str)
}

trait Uppercase extends Writer {
  abstract override def print(str: String) = 
    super.print(str.toUpperCase())
}






