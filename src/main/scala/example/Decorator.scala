object Decorator extends App {
  val armor = new ChainMail(new BasicArmor)
  println(armor.CalculateDamageFromHit( new Hit("head", 12)  ))
  println(armor.GetArmorIntegrity() )
}

// immutable
case class Hit (
  Location: String, Strength: Double
)

trait IArmor {
  def CalculateDamageFromHit(hit: Hit): Double
  def GetArmorIntegrity(): Double
}

class BasicArmor extends IArmor {
  def CalculateDamageFromHit(hit: Hit): Double = hit.Strength
  def GetArmorIntegrity(): Double = 1
}

class ChainMail(decoratedArmor: BasicArmor){
  def CalculateDamageFromHit(hit: Hit): Double = {
    val hits = hit.copy(Strength = hit.Strength*0.8)

    decoratedArmor.CalculateDamageFromHit(hits)
  }
  def GetArmorIntegrity(): Double = {
    decoratedArmor.GetArmorIntegrity() *0.9
  }
}




