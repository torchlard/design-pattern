// object IteratorPattern extends App {
//   val namesRepository = new NameRepository

//   var iter = namesRepository.getIterator()
//   do {
//     println("Name: " + iter.next())
//   } while (iter.hasNext())
// }


// trait Container {
//   def getIterator(): Iterator
// }

// trait Iterator {
//   def hasNext(): Boolean
//   def next(): Object
// }

// class NameRepository() extends Container {
//   val names = Array("Robert", "John", "Julie", "Lora")

//   def getIterator(): Iterator = new NameIterator()

//   class NameIterator extends Iterator {
//     var index = 0
    
//     def hasNext() = if(index < names.length) true else false
//     def next(): Object = {
//       if(this.hasNext()) { 
//         index += 1
//         println(s"index: $index")
//         return names(index-1) 
//       } else null
//     }
//   }
// }







