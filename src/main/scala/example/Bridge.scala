package example

import scala.List

// object Bridge extends App {
//   val god1 = new OldGodsAdapter
//   val god2 = new DrownedGodAdapter
//   val god3 = new SevenGodAdapter

//   god1.prayTo
//   god2.prayTo
//   god3.prayTo
// }

trait God[T] {
  def prayTo(a: T): Unit
}

class OldGods extends God[Sacrifice] {
  def prayTo(sacrifice: Sacrifice) {
    println("we old gods hear your prayer")
  }
}

class DrownedGod extends God[HumanSacrifice] {
  def prayTo(humanSacrifice: HumanSacrifice){
    println("*BUBBLE* GURGLE")
  }
}

class SevenGod extends God[PrayerPurposeProvider] {
  def prayTo(prayerPurpose: PrayerPurposeProvider){
    println("sorry there are lot of us. did you pray for sth?")
  }
}

class Sacrifice {}
class HumanSacrifice{}
class PrayerPurposeProvider{}

class OldGodsAdapter {
  val a="d"
  def prayTo() = { (new OldGods).prayTo(new Sacrifice)}
}
class DrownedGodAdapter {
  val a="d"
  def prayTo() = { (new DrownedGod).prayTo(new HumanSacrifice) }
}
class SevenGodAdapter {
  val a="d"
  def prayTo() = { (new SevenGod).prayTo(new PrayerPurposeProvider) }
}










