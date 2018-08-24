// object Adapter extends App {
//   val ship = new ShipAdapter
//   ship.TurnLeft()
//   ship.TurnLeft()
//   ship.TurnRight()
//   ship.GoForward()
// }

trait Ship {
  private var angle:Float = 0
  private var speed:Float = 0
  def SetRudderAngleTo(ang: Float) {
    println(s"set rudder angle to $angle")
    angle += ang
  }
  def SetSailAngle(sailId: Float, sailAngle: Float) = {
    println("set sail angle")
    angle += sailAngle
    speed += 10
  }
  def GetCurrentBearing: Float = {angle}
  def GetCurrentSpeedEstimate: Float = {speed}
  def SetSpeedTo(spd: Float) {speed = spd}
}

trait SimpleShip {
  def TurnLeft()
  def TurnRight()
  def GoForward()
}

class ShipAdapter extends SimpleShip with Ship {
  
  def TurnLeft() = {
    SetRudderAngleTo(-30)
    SetSailAngle(3, 12)
  }
  
  def TurnRight() = {
    SetRudderAngleTo(30)
    SetSailAngle(5, -9)
  }

  def GoForward() = {
    SetSpeedTo(24)
    println(s"the current bearing is $GetCurrentBearing ")
    println(s"the current speed is $GetCurrentSpeedEstimate ")
  }

}


object Adapter {

  def main(args: Array[String]): Unit = {
    val ship = new ShipAdapter
    ship.TurnLeft()
    ship.TurnLeft()
    ship.TurnRight()
    ship.GoForward()
  }
}





