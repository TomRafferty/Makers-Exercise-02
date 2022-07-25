class Agenda (val meetings: List[Meeting]) {

  def printDaySchedule(day: String): Unit = {
    val meetingsForTheDay = meetings.filter(_.day == day)
    val meetingsAM = meetingsForTheDay.filter(meeting => meeting.time.contains("am"))
    val meetingsPM = meetingsForTheDay.filter(meeting => meeting.time.contains("pm"))

    def meetingPrinter(meetings: List[Meeting]): Unit = {
      meetings.foreach(meeting => {
        println(s"${meeting.time}: ${meeting.name}")
      })
    }
    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
    println(s"$day:")
    if(meetingsForTheDay.length > 0){
      if(meetingsAM.length > 0){
        println("AM Meetings:")
        println("-------------")
        meetingPrinter(meetingsAM)
      }else{
        println("There are no AM meetings scheduled")
      }
      if(meetingsPM.length > 0){
        println("PM Meetings:")
        println("-------------")
        meetingPrinter(meetingsPM)
      }else{
        println("There are no PM meetings scheduled")
      }
    }else{
      println(s"No meetings for $day")
    }
    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
    println()
  }
}

class Meeting (val name: String, val day: String, val time: String)

object Main extends App {
  val m1 = new Meeting("Yoga", "Tuesday", "10am")
  val m2 = new Meeting("Team Meeting", "Tuesday", "3pm")
  val m3 = new Meeting("Focus Time", "Wednesday", "2pm")
  val m4 = new Meeting("Game Dev", "Thursday", "6pm")
  val m5 = new Meeting("Meeting With Coffee", "Friday", "12pm")
  val m6 = new Meeting("Retro", "Friday", "5pm")

  val agenda = new Agenda(List(m1, m2, m3, m4, m5, m6))
  agenda.printDaySchedule("Monday")
  agenda.printDaySchedule("Tuesday")
  agenda.printDaySchedule("Wednesday")
  agenda.printDaySchedule("Thursday")
  agenda.printDaySchedule("Friday")
}