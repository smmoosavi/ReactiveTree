package ir.co.bayan.simorq.reactive.tree

/**
 * @author S.Hosein Ayat
 */
trait Generator[+T] {

  def generate: T
}
