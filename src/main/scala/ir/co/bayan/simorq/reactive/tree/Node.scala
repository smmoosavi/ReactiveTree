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

  def map[U](f: T => U): Node[U] = {
    val leftNode = if (left.isEmpty) None else Some(left.get.map(f))
    val rightNode = if (right.isEmpty) None else Some(right.get.map(f))
    Node[U](f(value), leftNode, rightNode)
  }

  /**
   * In fix implementation
   * @param state state
   * @param f activation function
   * @return result
   */
  def fold[U](state: U, f: (U, T) => U): U = {
    val leftState = if (left.isEmpty) state else left.get.fold(state, f)
    val middleState = f(leftState, value)
    val rightState = if (right.isEmpty) middleState else right.get.fold(middleState, f)
    return rightState
  }
}
