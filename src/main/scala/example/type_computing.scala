// object type_computing extends App {

//   /** Path dependent type */
//   val foo1 = new Foo
//   val foo2 = new Foo

//   // #: not refer to any specific instance
//   // .: only refer specific instance of Foo
//   val a: Foo#Bar = new foo1.Bar
//   val b: Foo#Bar = new foo2.Bar
//   val c: foo1.Bar = new foo1.Bar

//   println(a,b,c)

//   /** Parameter dependent types */
//   def alpha(f: Alpha): f.Beta = f.beta

//   /** Abstact type */
//   // function getValue change rturn type depend on input
//   def getValue(f: Fly): f.T = f.value

//   val fs: String = getValue(FlyString)
//   val fi: Int = getValue(FlyInt)
//   println(fs,fi)

//   /** Infix operator */
//   Fou.bau("hello")
//   Fou bau "hello"

//   type Test1 = Fau[Int, String]
//   type Test2 = Int Fau String

//   /** Phantom types */


// }

// class Foo {
//   class Bar
// }

// trait Alpha {
//   trait Beta
//   def beta: Beta
// }


// trait Fly {
//   type T
//   def value: T
// }

// object FlyString extends Fly {
//   type T = String
//   def value: T = "ciao"
// }

// object FlyInt extends Fly {
//   type T = Int
//   def value: T = 1
// }

// object Fou {
//   def bau(s: String) = println(s)
// }

// trait Fau[A,B]


