package ir.co.bayan.simorq.reactive.tree

/**
 * @author S.Hosein Ayat
 */
trait Tree {

  def toList: List[Int]

  def foreach(f: Int => Unit): Unit
}

case class InnerNode(left: Tree, right: Tree) extends Tree {

  override def toList: List[Int] = {
    left.toList ++ right.toList
  }

  override def foreach(f: (Int) => Unit): Unit = {
    left foreach f
    right.foreach(f)
  }
}

case class Leaf(value: Int) extends Tree {
  override def toList: List[Int] = value :: Nil

  override def foreach(f: (Int) => Unit): Unit = f(value)
}
