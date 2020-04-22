// this is written in Dotty / Scala 3
trait Eq[T] {

  // using equality instead of equals to avoid method name clashing
  def (a: T) equality (b: T): Boolean

}

// adding some useful syntactic sugar
object Eq {

  def apply[T](using eq: Eq[T]) = eq

}

// don't have to name it anymore!
given Eq[Int] {
  def (a: Int) equality (b: Int): Boolean = a == b
}

Eq.equality(1, 2)
