// import shapeless.test.illTyped

// object type_computing2 extends App {

//   type x = False#not

//   implicitly[True#and[False] =:= False]
//   illTyped("implicitly[False#not =:= False]")

//   val x1 = 1 :: 2 :: IntNil
//   val y1 = 10 :: 20 :: IntNil
  
//   println(x1, y1)
//   println(x1+y1)
//   // println(x1 + (1 :: IntNil))

// }

// /** Boolean system */

// sealed trait Boolean {
//   type not <: Boolean
//   type or[that <: Boolean] <: Boolean
//   type and[that <: Boolean] = this.type#not#or[that#not]#not
// }

// sealed trait True extends Boolean {
//   type not = False
//   type or[that <: Boolean] = True
//   // type and[that <: Boolean] = that
// }

// sealed trait False extends Boolean {
//   type not = True
//   type or[that <: Boolean] = that
//   // type and[that <: Boolean] = False
// }


// /** Peano number system  */

// sealed trait Peano {
//   type add[that <: Peano] <: Peano
// }

// sealed trait Zero extends Peano {
//   type add[that <: Peano] = that
// }

// sealed trait PeanoN[prev <: Peano] extends Peano {
//   type add[that <: Peano] = PeanoN[prev#add[that]]
// }

// sealed trait IntList[Size <: Peano] {
//   def ::(head: Int): IntList[PeanoN[Size]] = ConsIntList(head, this)
//   def +(other: IntList[Size]): IntList[Size]
// }

// case object IntNil extends IntList[Zero] {
//   def +(other: IntList[Zero]) = IntNil
// }

// case class ConsIntList[SizeTail <: Peano](head: Int, tail: IntList[SizeTail])
//   extends IntList[PeanoN[SizeTail]] {
//     def +(other: IntList[PeanoN[SizeTail]]) =
//       other match {
//         case ConsIntList(otherHead, otherTail) =>
//           (head + otherHead) :: (tail + otherTail)
//       }
// }



