trait Eq[T] {

  // using equality instead of equals to avoid method name clashing
  def equality(a: T, b: T): Boolean

}

// an instance of the type class for Int
implicit object EqInt extends Eq[Int] {

  def equality(a: Int, b: Int): Boolean = a == b

}

// an instance of the type class for String
implicit object EqString extends Eq[String] {

  def equality(a: String, b: String): Boolean = a == b

}

// this is what we already had achieved
def contains[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs =>
    val eq = implicitly[Eq[T]] // this is one way the lack of support shows in scala
    eq.equality(x, y) || contains(xs, y)
}

// adding some useful syntactic sugar
object Eq {

  def apply[T](implicit eq: Eq[T]) = eq

}

implicit class EqOps[T: Eq](val a: T) { // extends AnyVal { // won't work in a worksheet

  def equality(b: T): Boolean = Eq[T].equality(a, b)

}

// now I don't need the akward implicitly anymore
def contains2[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs => Eq[T].equality(x, y) || contains(xs, y)
}

import Eq._

// and now we can call .equality directly on any T that has a type class Eq defined
def contains3[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs => x.equality(y) || contains(xs, y)
}

contains3(List(0, 1, 2, 3), 0)  /*>  true  */
contains3(List(0, 1, 2, 3), 11)  /*>  false  */

contains3(List("Pierre", "Papier", "Ciseaux"), "Papier")  /*>  true  */
contains3(List("Pierre", "Papier", "Ciseaux"), "Carton")  /*>  false  */
