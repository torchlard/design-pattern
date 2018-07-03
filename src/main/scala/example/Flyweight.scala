import scala.collection.mutable.HashMap

object Flyweight extends App {

}

trait Shape {
  def draw(): Unit
}

class Circle(var color:String) extends Shape {
  var x: Int
  var y: Int
  var radius: Int

  def setX(xx: Int) = {x = xx}
  def setY(yy: Int) = {y = yy}
  def setRadius(rr: Int) = {radius = rr}

  def draw() = {
    println(s"x: $x, y: $y, radius: $radius, color: $color")
  }
}

object ShapeFactory {
  var circleMap: HashMap[String, Circle] = new HashMap()

  def getCircle(color: String): Shape = {

    if (circleMap(color) == null ){
      val circle = new Circle(color)
      
      circleMap += (color, circle)
      println("creating circle of color: "+color)
      return circle
    }

    return circleMap(color)
  }

}












