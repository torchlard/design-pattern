// import scala.collection.mutable.ArrayBuffer

// object ObserverPattern extends App {
//   val subject = new Subject()

//   new HexaObserver(subject)
//   new OctalObserver(subject)
//   new BinaryObserver(subject)

//   println("first state change: 15")
//   subject.setState(15)
//   println("second change: 20")
//   subject.setState(20)
// }

// class Subject {
//   private var observers = new ArrayBuffer[Observer]()
//   private var state = 0

//   def getState() = state
//   def setState(state: Int) = {
//     this.state = state
//     notifyAllObservers()
//   }

//   def attach(observer: Observer) = observers.append(observer)
//   def notifyAllObservers() = {
//     for(i <- observers) i.update()
//   }
// }

// abstract class Observer(subject: Subject) {
//   def update(): Unit
// }

// class BinaryObserver(subject: Subject) extends Observer(subject) {
//   subject.attach(this)
//   def update() = println( "binary: " +Integer.toBinaryString(subject.getState()))
// }

// class OctalObserver(subject: Subject) extends Observer(subject) {
//   subject.attach(this)
//   def update() = println("octal: " + Integer.toOctalString(subject.getState()))
// }

// class HexaObserver(subject: Subject) extends Observer(subject) {
//   subject.attach(this)
//   def update() = println("hexa: " + Integer.toHexString(subject.getState()))
// }




