trait Eq[T] {

  // using equality instead of equals to avoid method name clashing
  def equality(a: T, b: T): Boolean

}

// an instance of the type class for Int
object EqInt extends Eq[Int] {

  def equality(a: Int, b: Int): Boolean = eqInt(a, b)

  // this assumes eqInt is defined somewhere...
  private def eqInt (a: Int, b: Int): Boolean = ???

}

// an instance of the type class for Double
object EqString extends Eq[String] {

  def equality(a: String, b: String): Boolean = eqString(a, b)

  // this assumes eqInt is defined somewhere...
  private def eqString (a: String, b: String): Boolean = ???

}

// this is what we already had achived
def contains[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs =>
    val eq = implicitly[Eq[T]] // this is one way the lack of support shows in scala
    eq.equals(x, y) || contains(xs, y)
}

// adding some useful syntactic sugar
object Eq {

  def equality[T](a: T, b: T)(implicit eq: Eq[T]): Boolean  = eq.equals(a, b)

  implicit class EqOps[T: Eq](val a: T) { // extends AnyVal // won't work in a worksheet

    def equality(b: T): Boolean = Eq.equals(b)

  }

}

// now I don't need the akward implicitly anymore
def contains2[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs => Eq.equality(x, y) || contains(xs, y)
}

import Eq._

// and now we can call .equality directly on any T that has a type class Eq defined
def contains3[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs => x.equality(y) || contains(xs, y)
}
