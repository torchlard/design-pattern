package example

// object Hello extends App {
//   val dog = new Dog
//   dog.speak
//   dog.run
// }




abstract class Animal {
  def speak
}

trait WaggingTail {
  def startTrail {println("tail started")}
  def stopTail {println("tail stopped")}
}

trait FourLeggedAnimal {
  def walk
  def run
}

class Dog extends Animal with WaggingTail with FourLeggedAnimal {
  def speak {println("dog says 'woof'")}
  def walk {println("dog is walking")}
  def run() = {println("dog is running")}
}






