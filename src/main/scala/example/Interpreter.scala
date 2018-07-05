// object interpreter extends App {
//   def getMaleExpression(): Expression = {
//     val robert = new TerminalExpression("Robert")
//     val john = new TerminalExpression("John")
//     return new OrExpression(robert, john)
//   }

//   def getMarriedExpression(): Expression = {
//     val julie = new TerminalExpression("julie")
//     val married = new TerminalExpression("married")
//     return new AndExpression(julie, married)
//   }

//   val isMale = getMaleExpression()
//   val isMarried = getMarriedExpression()

//   println("John is male? " + isMale.interpret("John") )
//   println("Julie is married woman? " + isMarried.interpret("julie married") )
  
// }

// trait Expression {
//   def interpret(context: String): Boolean
// }

// class TerminalExpression(data: String) extends Expression {
//   def interpret(context: String) = {
//     if ( context.contains(data) ) true else false
//   }
// }

// class OrExpression(expr1: Expression, expr2: Expression) extends Expression {
//   def interpret(context: String) = expr1.interpret(context) || expr2.interpret(context)
// }

// class AndExpression(expr1: Expression, expr2: Expression) extends Expression {
//   def interpret(context: String) = expr1.interpret(context) && expr2.interpret(context)
// }



