import scala.collection.mutable.ArrayBuffer

// object Composition extends App {
//   val egg = new SimpleIngredient("Egg", 155, 6,0)
//   val milk = new SimpleIngredient("Milk", 42,0,0)
//   val sugar = new SimpleIngredient("Sugar", 387,0,0)
//   val rice = new SimpleIngredient("Rice", 370,8,0)

//   val ricePudding = new CompoundIngreditent("rice pudding")
//   ricePudding.addIngredient(egg)
//   ricePudding.addIngredient(milk)
//   ricePudding.addIngredient(sugar)
//   ricePudding.addIngredient(rice)

//   println("a service of rice padding contains")
//   println(ricePudding.GetCalories + " calories" )
// }

class SimpleIngredient(name:String, calories:Float, ironContent:Float, vitaminContent:Float ) {
  def GetName = name
  def GetCalories = calories
  def GetIronContent = ironContent
  def GetVitaminContent = vitaminContent  
}

class CompoundIngreditent (name: String, 
  ingredients: ArrayBuffer[SimpleIngredient]=ArrayBuffer()) {

  def addIngredient(ingredient: SimpleIngredient): Unit = {
    ingredients += ingredient
  }

  def GetName = name
  def GetCalories = ingredients.map( _.GetCalories ).reduce( (a,b) => a+b )
  def GetIronContent = ingredients.map(_.GetIronContent).reduce((a,b) => a+b)
  def GetVitaminContent = ingredients.map(_.GetVitaminContent).reduce((a,b)=>a+b)
  
}





