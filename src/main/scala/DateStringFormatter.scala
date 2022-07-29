import java.time.Instant

object DateStringFormatter{
  //although there is a built in date formatter this will
  //allow me to format the date to any style I like and also
  //allow me to add additional information to the date string

  private def formatter(date: String): String = {
    //format the current date string
    //gets a string like this:
    //2022-07-27T14:35:00Z
    //outputs this:
    //27-07-2022 @ 14:35
    //----------------------
    //Date time separation:
    val spltStepA = date.split("T") // Array("2022-07-27", "T", "14:35:00Z")
    val passedDate = spltStepA(0) //"2022-07-27"
    val passedTime = spltStepA(1) //"14:35:00Z"
    //----------------------
    //dd/mm/yyyy separation:
    val spltStepB = passedDate.split("-").filter(x => x != "-") // Array("2022", "07", "27")
    val day = spltStepB(2)
    val month = spltStepB(1)
    val year = spltStepB(2)
    //----------------------
    //time formatting:
    val spltStepC = passedTime.split(":") //Array("14", ":", "35", ":", "00Z")
    val time = s"${spltStepC(0)}:${spltStepC(1)}" //"14:35"
    //----------------------
    //return formatted date time string:
    f"""
       |Receipt issued:
       |Date: $day/$month/$year
       |Time: $time
       |""".stripMargin
  }

  def format(dateString:Instant):String ={
    formatter(dateString.toString)
  }
}
