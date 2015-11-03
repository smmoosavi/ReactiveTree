package ir.co.bayan.simorq.reactive.tree

/**
 * @author S.Hosein Ayat
 */
trait Tree[T] {

  def toList: List[T]

  def foreach(f: T => Unit): Unit
}

case class InnerNode[T](left: Tree[T], right: Tree[T]) extends Tree[T] {

  override def toList: List[T] = {
    left.toList ++ right.toList
  }

  override def foreach(f: (T) => Unit): Unit = {
    left foreach f
    right.foreach(f)
  }
}

case class Leaf[T](value: T) extends Tree[T] {
  override def toList: List[T] = value :: Nil

  override def foreach(f: (T) => Unit): Unit = f(value)
}
