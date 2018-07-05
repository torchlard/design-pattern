
// object ChainOfResponsibility extends App {
//   val com = new ComplaintResolver
//   val response = com.resolveComplaint( Complaint("clert", "", ""))
//   println(s"response: $response")
// }

trait ComplaintListener {
  def isAbleToResolveComplaint(complaint: Complaint): Boolean
  def listenToComplaint(complaint: Complaint): String
}

case class Complaint (
  complainingParty: String, complaintAbout: String, complaint: String
)

class ClerOfTheCourt extends ComplaintListener {
  def isAbleToResolveComplaint(complaint: Complaint) = {complaint.complainingParty == "clert"}
  def listenToComplaint(complaint: Complaint) = {
    println("clert listening ..")
    "good good study"
  }
}

class HandOfKing extends ComplaintListener {
  def isAbleToResolveComplaint(complaint: Complaint) = {complaint.complainingParty == "hand"}
  def listenToComplaint(complaint: Complaint) = {
    println("hand of king listening ..")
    "day day up"
  }
}

class King extends ComplaintListener {
  def isAbleToResolveComplaint(complaint: Complaint) = true
  def listenToComplaint(complaint: Complaint) = {
    println("king listening ..")
    "yeah"
  }
}

class ComplaintResolver {
  // val clert: ComplaintListener = new ClerOfTheCourt
  // val hand: ComplaintListener = new HandOfKing
  // val king: ComplaintListener = new King
  // val complaintListener: Array[ComplaintListener] = Array(clert, hand, king)
  val complaintListener = Array(new ClerOfTheCourt, new HandOfKing, new King)

  def resolveComplaint(complaint: Complaint): String = {

    for (i <- complaintListener) {
      if (i.isAbleToResolveComplaint(complaint)) {
        return i.listenToComplaint(complaint)
      }
    }
    return ""
  }

}





