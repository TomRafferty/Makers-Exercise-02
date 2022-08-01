import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OrderBuilderTest extends AnyWordSpec with Matchers {
  "A order" should {
    "format given information" which {
      "should contain all items" in {
        val order = OrderBuilder.create(Map(
          "Caffe Latte" -> 2,
          "Flat White" -> 1
        ))
        order should include("Caffe Latte")
        order should include("Flat White")
      }

      "should calculate sub total" in {
        val order = OrderBuilder.create(Map(
          "Caffe Latte" -> 2,
          "Flat White" -> 1
        ))
        order should include("Caffe Latte")
        order should include("Flat White")
      }
    }
  }
}