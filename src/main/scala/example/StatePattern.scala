
object StatePattern extends App {
  val context = new Context()
  val startState = new StartState
  val stopState = new StopState

  // go to start state
  startState.doAction(context)
  println(context.state)
  
  // go to stop state
  stopState.doAction(context)  
  println(context.state)
}

class Context(var state: State = null){}

trait State {
  def doAction(context: Context): Unit
}

class StartState extends State {
  def doAction(context: Context) = {
    println("players is in start state")
    context.state = this
  }

  override def toString = "Start State"
}

class StopState extends State {
  def doAction(context: Context) = {
    println("players is in stop state")
    context.state = this
  }

  override def toString = "Stop State"
}





