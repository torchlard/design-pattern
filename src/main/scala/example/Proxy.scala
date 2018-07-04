// object Proxy extends App {

//   val image = new ProxyImage("text_10mb.jpg")
//   image.display()
//   println(" ")
//   image.display()

// }

// trait Image {
//   def display(): Unit
// }

// class RealImage extends Image {

//   private var fileName = ""

//   def this(fileName: String){
//     this()
//     this.fileName = fileName
//     loadFromDisk(fileName)
//   }

//   def display() = println(s"this is image $fileName")
//   def loadFromDisk(fileName: String) = println(s"loading image $fileName from disk")
    
// }

// class ProxyImage(fileName: String) extends Image {

//   private var realImage = new RealImage("")

//   def display() = {
//     realImage = new RealImage(fileName)
//     realImage.display()
//   }

// }




