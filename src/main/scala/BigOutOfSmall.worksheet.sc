trait Eq[T] {

  // using equality instead of equals to avoid method name clashing
  def equality(a: T, b: T): Boolean

}

// adding some useful syntactic sugar
object Eq {

  def equality[T](a: T, b: T)(implicit eq: Eq[T]): Boolean  = eq.equality(a, b)

}

implicit class EqOps[T: Eq](val a: T) { // extends AnyVal // won't work in a worksheet

  def equality(b: T): Boolean = Eq.equality(a, b)

}

implicit def eqList[T: Eq] = new Eq[List[T]] {
  def equality(a: List[T], b: List[T]) = (a, b) match {
    case (Nil, Nil) => true
    case (Nil, y :: ys) => false
    case (x :: xs, Nil) => false
    case (x :: xs, y :: ys) => x.equality(y) && equality(xs, ys)
  }
}

// an instance of the type class for Int
implicit object EqInt extends Eq[Int] {

  def equality(a: Int, b: Int): Boolean = a == b

}

List(1, 2, 3).equality(List(2, 3, 4))  /*>  false  */
List(1, 2, 3).equality(List(1, 2, 3))  /*>  true  */

// but this doesn't compile because Eq[Double] isn't defined
List(1d, 2d).equality(List(1d, 2d))
