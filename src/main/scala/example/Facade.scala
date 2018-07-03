// object Facade extends App {
//   val shapeMaker = new ShapeMaker()

//   shapeMaker.drawCircle()
//   shapeMaker.drawRectangle()
//   shapeMaker.drawSquare()
  
// }

// trait Shape {
//   def draw()
// }

// class Rectangle extends Shape {
//   def draw(): Unit = {
//     println("rectangle draw")
//   }
// }

// class Circle extends Shape {
//   def draw(): Unit = {
//     println("circle draw")
//   }
// }

// class Square extends Shape {
//   def draw(): Unit = {
//     println("square draw")
//   }
// }

// class ShapeMaker(circle: Shape, rectangle: Shape, square: Shape) {
//   def this() {
//     this(new Circle, new Rectangle, new Square )
//   }

//   def drawCircle(): Unit = circle.draw()
//   def drawRectangle(): Unit = rectangle.draw()
//   def drawSquare(): Unit = square.draw()
// }



