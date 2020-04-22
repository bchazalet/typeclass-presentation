// re-writting Wadler's paper's example in scala
// in scala type classes can be encoded in the following way

// the actual type class defining the set of operations
trait Eq[T] {

  // not a great name because on the JVM!
  def ==(a: T, b: T): Boolean

}

// an instance of the type class for Int
object EqInt extends Eq[Int] {

  def ==(a: Int, b: Int): Boolean = ???

}

// an instance of the type class for Double
object EqString extends Eq[String] {

  def ==(a: String, b: String): Boolean = ???

}

// now we can defined a generic contains function, as long as we can use equals
// on the given type
def contains[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs =>
    val eq = implicitly[Eq[T]] // this is one way the lack of support shows in scala
    eq.==(x, y) || contains(xs, y)
}

// or, equivalently:
// def contains2[T](list: List[T], y: T)(implicit eq: Eq[T]): Boolean = list match {
//   case Nil => false
//   case x :: xs => eq.`==`(x, y) || contains(xs, y)
// }
