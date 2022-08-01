object OrderBuilder{
  def create(order: Map[String, Int]): String = {
    val orderItems = order.map(item => {
      s"${item._1} X${item._2}"
    }).mkString("\n")
    orderItems
  }
}
