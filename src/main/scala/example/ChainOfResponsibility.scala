import scala.collection.mutable.ArrayBuffer

object ChainOfResponsibility extends App {
  val com = new ComplaintResolver
  com.resolveComplaint( Complaint("king", "", ""))
}

trait ComplaintListener {
  isAbleToResolveComplaint(complaint: Complaint): Boolean
  listenToComplaint(complaint: Complaint): String
}

case class Complaint (
  complainingParty: String, complaintAbout: String, complaint: String
)

class ClerOfTheCourt extends ComplaintListener {
  isAbleToResolveComplaint(complaint: Complaint) = {complaint.complainingParty == "clert"}

  listenToComplaint(complaint: Complaint) = {
    println("clert listening ..")
    ""
  }
}

class HandOfKing extends ComplaintListener {
  isAbleToResolveComplaint(complaint: Complaint) = {complaint.complainingParty == "hand of king"}
  listenToComplaint(complaint: Complaint) = {
    println("hand of king listening ..")
    ""
  }
}

class King extends ComplaintListener {
  isAbleToResolveComplaint(complaint: Complaint) = true
  listenToComplaint(complaint: Complaint) = {
    println("king listening ..")
    ""
  }
}

class ComplaintResolver {
  val clert: ComplaintListener = new ClerOfTheCourt
  val hand: ComplaintListener = new HandOfKing
  val king: ComplaintListener = new King
  val complaintListener: ArrayBuffer[ComplaintListener] = new ArrayBuffer(clert, hand, king)

  def resolveComplaint(complaint: Complaint): Unit = {
    for (i <- complaintListener) {
      if (i.isAbleToResolveComplaint(complaint)) {
        i.listenToComplaint(complaint)
        return
      }
    }

  }

}





