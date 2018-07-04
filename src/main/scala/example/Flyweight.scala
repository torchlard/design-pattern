// import scala.util.Random
// import scala.collection.mutable.HashMap

// object Flyweight extends App {
//   val colors = Array("Red", "Green", "Blue", "White", "Black", "Pink")

//   def getRandomColor = colors(Random.nextInt(colors.length))

//   for(i <- 0 to 20) {
//     var circle = ShapeFactory.getCircle(getRandomColor)
//     circle.setX(Random.nextInt(50))
//     circle.setY(Random.nextInt(50))
//     circle.setRadius(Random.nextInt(30))
//     circle.draw()
//   }
  
// }

// trait Shape {
//   def draw(): Unit
// }

// class Circle(var color:String) extends Shape {
//   private var x: Int = 0
//   private var y: Int = 0
//   private var radius: Int = 0

//   def setX(xx: Int) = {x = xx}
//   def setY(yy: Int) = {y = yy}
//   def setRadius(rr: Int) = {radius = rr}

//   def draw() = {
//     println(s"x: $x, y: $y, radius: $radius, color: $color")
//   }
// }

// object ShapeFactory {
//   private var circleMap: HashMap[String, Circle] = new HashMap()

//   def getCircle(color: String): Circle = {

//     if (! (circleMap contains color) ){
//       val circle = new Circle(color)
      
//       circleMap.put(color, circle)
//       println("creating circle of color: "+color)
//       return circle
//     }

//     return circleMap(color)
//   }

// }













