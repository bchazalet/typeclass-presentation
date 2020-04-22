// re-writting Wadler's paper's example in scala
// in scala type classes can be encoded in the following way

// the actual type class defining the set of operations
trait Eq[T] {

  // not a great name because on the JVM!
  def equals(a: T, b: T): Boolean

}

// an instance of the type class for Int
object EqInt extends Eq[Int] {

  def equals(a: Int, b: Int): Boolean = eqInt(a, b)

  // this assumes eqInt is defined somewhere...
  private def eqInt (a: Int, b: Int): Boolean = ???

}

// an instance of the type class for Double
object EqString extends Eq[String] {

  def equals(a: String, b: String): Boolean = eqString(a, b)

  // this assumes eqInt is defined somewhere...
  private def eqString (a: String, b: String): Boolean = ???

}

// now we can defined a generic contains function, as long as we can use equals
// on the given type
def contains[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs =>
    val eq = implicitly[Eq[T]] // this is one way the lack of support shows in scala
    eq.equals(x, y) || contains(xs, y)
}

// or, equivalently:
// def contains2[T](list: List[T], y: T)(implicit eq: Eq[T]): Boolean = list match {
//   case Nil => false
//   case x :: xs => eq.equals(x, y) || contains(xs, y)
// }
