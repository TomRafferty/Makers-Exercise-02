import com.github.nscala_time.time.Imports._

class CafeDetails (
  val shopName: String,
  val address: String,
  val phone: String,
  val prices: Map[String, Double]
)

class ReceiptPrinter(val cafe: CafeDetails, var order: Map[String, Int] = Map()) {

  /**
   * This method should return a multiline string
   * representing a ReceiptPrinter receipt that should show
   * - shop name, address, phone number
   * - the date and time the receipt was created
   * - each item in the order, with the price. eg:
   *     2 x Blueberry Muffin       8.10
   *     1 x Cappuccino             3.85
   * - the total price
   * - the VAT (20% of total price)
   */
  def dateFormatter(date: DateTime): String = {
    //date looks like:
    //2022-07-26T13:34:05.086+01:00
    val dateStr = s"$date".split("T")(0)
    val timeStr = s"$date".split("T")(1).split("\\.")(0)
    s"Date: $dateStr\nTime: $timeStr"
  }
  def gbpFormatter(num: Double): String = {
    if(num.toString.split("\\.")(1).length == 1){
      s"£${num}0"
    }else{
      s"£$num"
    }
  }
  def createOrderString(order: Map[String, Int]): String = {
    val orderKeys = order.keys.toArray
    val columns = orderKeys.zipWithIndex.map{case(key,index) => {
      val itemPrice = cafe.prices.filter(x => x._1 == key).values.toList.head
      val itemQuantity = order.filter(x => x._1 == key).values.toList.head
      def columnCost = gbpFormatter(itemPrice * itemQuantity)
      if(index < orderKeys.length - 1){
        s"${itemQuantity}x        |       $key        |       price: $columnCost"
      }else{
        s"${itemQuantity}x        |       $key        |       price: $columnCost\nTotal: "
      }
    }}.mkString("\n")
    columns
  }
  def receipt: String = {
    val name = s"${cafe.shopName}\n"
    val address = s"${cafe.address}\n"
    val phone = s"Phone Number: ${cafe.phone}\n"
    val orderTime = s"${dateFormatter(DateTime.now())}\n"
    val orderStr = s"order:\n${createOrderString(order)}\n"
    s"$name$address$phone$orderTime$orderStr"
  }
  println(receipt)
}