import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ReceiptPrinterTest extends AnyWordSpec with Matchers {
  val coffeeConnectionCafe = new CafeDetails(
    "The Coffee Connection",
    "123 Lakeside Way",
    "16503600708",
    Map(
      "Cafe Latte" -> 4.75,
      "Flat White" -> 4.75,
      "Cappuccino" -> 3.85,
      "Single Espresso" -> 2.05,
      "Double Espresso" -> 3.75,
      "Americano" -> 3.75,
      "Cortado" -> 4.55,
      "Tea" -> 3.65,
      "Choc Mudcake" -> 6.40,
      "Choc Mousse" -> 8.20,
      "Affogato" -> 14.80,
      "Tiramisu" -> 11.40,
      "Blueberry Muffin" -> 4.05,
      "Chocolate Chip Muffin" -> 4.05,
      "Muffin Of The Day" -> 4.55
    )
  )

  "A ReceiptPrinter" should {
    "format a receipt" which {
      "contains the name of the cafe" in {
        val printer = new ReceiptPrinter(
          coffeeConnectionCafe,
          Map("Cafe Latte" -> 1)
        )
        printer.receipt should include ("The Coffee Connection")
      }
      // add more tests here.
      "has the correct quantity" in {
        val printer = new ReceiptPrinter(
          coffeeConnectionCafe,
          Map("Cafe Latte" -> 3)
        )
        printer.receipt should include ("3x")
      }
      "displays the correct total price" in {
        val printer = new ReceiptPrinter(
          coffeeConnectionCafe,
          Map("Choc Mudcake" -> 2)
        )
        printer.receipt should include("£12.80")
      }
      "Multiple order items" in {
        val printer = new ReceiptPrinter(
          coffeeConnectionCafe,
          Map(
            "Choc Mudcake" -> 1,
            "Cafe Latte" -> 2
          )
        )
        printer.receipt should include("Choc Mudcake")
        printer.receipt should include("Cafe Latte")
        printer.receipt should include("£15.90")
      }
    }
  }
}