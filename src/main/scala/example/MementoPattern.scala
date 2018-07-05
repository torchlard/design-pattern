// import scala.collection.mutable.ArrayBuffer

// object MementoPattern extends App {
//   val originator = new Originator()
//   val careTaker = new CareTaker()

//   originator.setState("state #1")
//   originator.setState("state #2")
//   careTaker.add(originator.saveStateToMemento())

//   originator.setState("state #3")
//   careTaker.add(originator.saveStateToMemento())

//   originator.setState("state #4")
//   println("current state: " + originator.getState())

//   originator.getStateFromMemento(careTaker.get(0))
//   println("first state: " + originator.getState())

//   originator.getStateFromMemento(careTaker.get(1))
//   println("second state: " + originator.getState())

// }

// class Memento(var state: String){}

// class Originator {
//   private var state: String = ""

//   def setState(_state: String) = { this.state = _state }
//   def getState() = this.state

//   def saveStateToMemento(): Memento = new Memento(state)
//   def getStateFromMemento(memento: Memento) = { this.state = memento.state}
  
// }


// class CareTaker {
//   private var mementoList = new ArrayBuffer[Memento]()

//   def add(state: Memento) = mementoList.append(state)
//   def get(index: Int) = mementoList(index)
// }




