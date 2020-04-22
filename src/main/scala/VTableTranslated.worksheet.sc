// preparation
def plusInt(a: Int, b: Int) = ???
def multInt(a: Int, b: Int) = a * b
def negInt(a: Int) = ???








// translated
case class Num[T](
  add: (T, T) => T,
  mult: (T, T) => T,
  negate: T => T
)

def square[T](dict: Num[T], x: T): T = dict.mult(x, x)

val dNumInt = Num(plusInt, multInt, negInt)  /*>  Num(<function2>, <function2>, <function1>)  */





square(dNumInt, 2)  /*>  4  */
