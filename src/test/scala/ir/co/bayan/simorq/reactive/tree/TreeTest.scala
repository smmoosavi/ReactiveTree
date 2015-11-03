package ir.co.bayan.simorq.reactive.tree

import org.scalatest.{FlatSpec, Matchers}

/**
 * @author S.Hosein Ayat
 */
class TreeTest extends FlatSpec with Matchers {
  implicit def convertToLeaf(value: Int): Leaf[Int] = Leaf(value)

  val tree = InnerNode[Int](Leaf(2), Leaf(3))
  val tree2: InnerNode[Int] = InnerNode(InnerNode(2, InnerNode(1, 2)), InnerNode(4, 5))

  "Tree" can "create an ordered list of it's elements" in {
    tree.toList shouldBe List(2, 3)
    tree2.toList shouldBe List(2, 1, 2, 4, 5)
  }


  it can "print all elements using foreach" in {
    tree2 foreach println
  }

  it should "Generate another tree using map function" in {


    val tree3 = tree2.map(_.toString)

    tree3.toList shouldBe List("2", "1", "2", "4", "5")
  }


  it should "Generate a tree of Squared root values of original tree" in {

    val sqrt: Int => Tree[Int] = value => {
      val s: Int = Math.sqrt(value).toInt
      InnerNode(Leaf(s), Leaf(s))
    }

    val testTree = InnerNode(InnerNode(4, 9), 16)
    val resultTree = testTree.flatMap(sqrt)

    resultTree.toList shouldBe List(2, 2, 3, 3, 4, 4)
  }
}
