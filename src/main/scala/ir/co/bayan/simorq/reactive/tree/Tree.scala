package ir.co.bayan.simorq.reactive.tree

/**
 * @author S.Hosein Ayat
 */
trait Tree[T] {

  def toList: List[T]

  def foreach(f: T => Unit): Unit

  def map[U](f: T => U): Tree[U]

  def flatMap[U](f: T => Tree[U]): Tree[U]
}

case class InnerNode[T](left: Tree[T], right: Tree[T]) extends Tree[T] {

  override def toList: List[T] = {
    left.toList ++ right.toList
  }

  override def foreach(f: (T) => Unit): Unit = {
    left foreach f
    right.foreach(f)
  }

  override def map[U](f: (T) => U): Tree[U] = InnerNode(left map f, right map f)

  override def flatMap[U](f: (T) => Tree[U]): Tree[U] = {
    InnerNode(left flatMap f , right flatMap f)
  }
}

case class Leaf[T](value: T) extends Tree[T] {
  override def toList: List[T] = value :: Nil

  override def foreach(f: (T) => Unit): Unit = f(value)

  override def map[U](f: (T) => U): Tree[U] = Leaf(f(value))

  override def flatMap[U](f: (T) => Tree[U]): Tree[U] = {
    f(value)
  }
}
