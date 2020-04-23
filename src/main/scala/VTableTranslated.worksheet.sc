// preparation
def plusInt(a: Int, b: Int) = ???
def multInt(a: Int, b: Int) = a * b
def negInt(a: Int) = ???








// translated
case class Num[T](
  _add: (T, T) => T,
  _mult: (T, T) => T,
  _negate: T => T
)

def mult[T](num: Num[T]): (T, T) => T = num match {
  case Num(_, m, _) => m
}

def square[T](dict: Num[T], x: T): T = mult(dict)(x, x)

val dNumInt = Num(plusInt, multInt, negInt)  /*>  Num(<function2>, <function2>, <function1>)  */





square(dNumInt, 2)  /*>  4  */
