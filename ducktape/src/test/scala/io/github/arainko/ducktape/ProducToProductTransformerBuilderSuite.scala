package io.github.arainko.ducktape

import io.github.arainko.ducktape.*
import munit.*

case class Product1(int: Int, str: String, list: List[Int])
case class Product2(
  optInt: Option[Int],
  str: String,
  list: List[Int],
  additional: Double,
  computed: Map[String, String]
)

class MySuite extends FunSuite {

  test("Product to Product should compile") {
    val prod1 = Product1(1, "prod1", List(1, 2, 3, 4))
    val transformed =
      TransformerBuilder
        .create[Product1, Product2]
        .withFieldComputed["computed"](from => Map(from.str -> from.str))
        .withFieldConst["additional"](5)
        .withFieldRenamed["int", "optInt"]
        .transformProdcutToProduct(prod1)

    println(transformed)
  }
}