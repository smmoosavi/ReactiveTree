package ir.co.bayan.simorq.reactive.tree

import org.scalatest.{FlatSpec, Matchers}

/**
 * @author S.Hosein Ayat
 */
class TreeTest extends FlatSpec with Matchers {
  implicit def convertToLeaf(value: Int): Leaf = Leaf(value)

  val tree = InnerNode(Leaf(2), Leaf(3))
  val tree2: InnerNode = InnerNode(InnerNode(2, InnerNode(1, 2)), InnerNode(4, 5))

  "Tree" can "create an ordered list of it's elements" in {
    tree.toList shouldBe List(2, 3)
    tree2.toList shouldBe List(2 , 1 , 2 , 4 , 5)
  }


  it can "print all elements using foreach" in {
    tree2 foreach println
  }

}
