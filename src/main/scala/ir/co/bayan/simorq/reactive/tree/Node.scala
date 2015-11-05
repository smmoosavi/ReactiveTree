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
    left.map(_.toList).getOrElse(Nil) ++ (value :: Nil) ++ right.map(_.toList).getOrElse(Nil)
  }

  def map[U](f: T => U): Node[U] = {
    Node[U](f(value), left.map(_ map f), right.map(_ map f))
  }

  /**
   * In fix implementation
   * @param state state
   * @param f activation function
   * @return result
   */
  def fold[U](state: U, f: (U, T) => U): U = {
    val leftState = left.map(_.fold(state, f)).getOrElse(state)
    val middleState = f(leftState, value)
    val rightState = right.map(_.fold(middleState, f)).getOrElse(middleState)
    return rightState
  }
}
