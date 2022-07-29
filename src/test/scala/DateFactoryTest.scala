import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.time.{Clock, Instant, ZoneId}

class DateFactoryTest extends AnyWordSpec with Matchers {
  val newDate = DateFactory

  "A DateFactory" should {
    "create an new Instant" which {
      "is an Instant" in {
        DateFactory.create() shouldBe a[Instant]
      }
      "has the specified time" in {
        val mockTime = "2022-07-27T14:35:00Z"
        val fixedClock = Clock.fixed(Instant.parse(mockTime),ZoneId.systemDefault())
        val subject = DateFactory.create(fixedClock)
        subject shouldBe a[Instant]
        subject.toString() shouldBe mockTime
      }
    }
  }
}