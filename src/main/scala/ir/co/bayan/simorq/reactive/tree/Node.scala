package ir.co.bayan.simorq.reactive.tree

/**
 * @author S.Hosein Ayat
 */
case class Node[T](value: T, left: Option[Node[T]] = None, right: Option[Node[T]] = None) {
  /**
   * In fix traverse
   * @return list of Ts
   */
  def toList: List[T] = {

    val leftList: List[T] = if (left.isEmpty) Nil else left.get.toList
    val middleList = value :: Nil
    val rightList: List[T] = if (right.isEmpty) Nil else right.get.toList
    leftList ++ middleList ++ rightList
  }

  def map[U](f: T => U): Node[U] = ???

  /**
   * In fix implementation
   * @param state state
   * @param f activation function
   * @return result
   */
  def fold(state: T, f: (T, T) => T): T = ???
}
