package ir.co.bayan.simorq.reactive.tree

/**
 * @author S.Hosein Ayat
 */
case class Node[T](value: T, left: Option[Node[T]], right: Option[Node[T]]) {
  /**
   * In fix traverse
   * @return list of Ts
   */
  def toList: List[T] = ???

  def map[U](f: T => U): Node[U] = ???

  /**
   * In fix implementation
   * @param state state
   * @param f activation function
   * @return result
   */
  def fold(state: T, f: (T, T) => T): T = ???
}
