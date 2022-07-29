import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.time.{Clock, Instant, ZoneId}

class DateStringFormatterTest extends AnyWordSpec with Matchers {
  val newFormattedDate = DateStringFormatter

  "DateStringFormatter" should {
    "format a given String" which {
      "has the specified time" in {
        val mockTime = "2022-07-27T14:35:00Z"
        val fixedClock = Clock.fixed(Instant.parse(mockTime),ZoneId.systemDefault())
        val dateInstant = DateFactory.create(fixedClock)
        dateInstant shouldBe a[Instant]
        val subject = DateStringFormatter.format(dateInstant)
        subject shouldBe
          f"""
             |Receipt issued:
             |Date: 27/07/27
             |Time: 14:35
             |""".stripMargin
      }
    }
  }
}