// this is written in Dotty / Scala 3
trait Eq[T] {

  // using equality instead of equals to avoid method name clashing
  def equality(a: T, b: T): Boolean

}

// adding some useful syntactic sugar
object Eq {

  def apply[T](implicit eq: Eq[T]) = eq

}
