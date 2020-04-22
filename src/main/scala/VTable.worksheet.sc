// preparation
def plusInt(a: Int, b: Int) = ???
def multInt(a: Int, b: Int) = a * b
def negInt(a: Int) = ???

// just to make square closer to the haskell version
object Num {

  def apply[T](implicit num: Num[T]) = num

}

// definition
trait Num[T] {
  def add(a: T, b: T): T
  def mult(a: T, b: T): T
  def negate(a: T): T
}

def square[T: Num](x: T): T = Num[T].mult(x, x)

implicit object NumInt extends Num[Int] {
  def add(a: Int, b: Int): Int = plusInt(a, b)
  def mult(a: Int, b: Int): Int = multInt(a, b)
  def negate(a: Int): Int = negInt(a)
}

square(2)  /*>  4  */
