package ir.co.bayan.simorq.reactive.tree

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Seyyed Morteza Moosavi
  */
class NodeTest extends FlatSpec with Matchers {
  implicit def convertToNode[T](value: T): Node[T] = Node(value, None, None)

  val tree = Node[Int](1, Some(2), Some(3))
  val tree2 = Node[String]("1", Some("2"), Some("3"))

  "Node" can "create an ordered list of it's elements" in {
    tree.toList shouldBe List(2, 1, 3)
    tree2.toList shouldBe List("2", "1", "3")
  }

  it should "Generate another tree using map function" in {
    val tree4: Node[String] = tree.map((x: Int) => (x + 2).toString)
    tree4.toList shouldBe List("4", "3", "5")
  }
}
