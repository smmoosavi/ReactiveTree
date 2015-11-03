package ir.co.bayan.simorq.reactive.tree

/**
 * @author S.Hosein Ayat
 */
trait Tree

case class InnerNode(left : Tree , right : Tree) extends Tree
case class Leaf(value : Int) extends Tree
