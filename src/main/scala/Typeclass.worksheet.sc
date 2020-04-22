trait Eq[T] {

  def equals(a: T, b: T): Boolean

}

object EqInt extends Eq[Int] {

  def equals(a: Int, b: Int): Boolean = eqInt(a, b)

  // this assumes eqInt is defined somewhere...
  private def eqInt (a: Int, b: Int): Boolean = ???

}

object EqString extends Eq[String] {

  def equals(a: String, b: String): Boolean = eqString(a, b)

  // this assumes eqInt is defined somewhere...
  private def eqString (a: String, b: String): Boolean = ???

}


def contains[T: Eq](list: List[T], y: T): Boolean = list match {
  case Nil => false
  case x :: xs => implicitly[Eq[T]].equals(x, y) || contains(xs, y)
}
