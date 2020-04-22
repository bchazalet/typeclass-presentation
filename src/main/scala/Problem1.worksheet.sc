// Problem1: overloading of numeric operators
// in a language where you have multiple numeric types
val a: Int = 2  /*>  2  */
val b: Int = 3  /*>  3  */

val c: Double = 2.21d  /*>  2.21  */
val d: Double = 3.14d  /*>  3.14  */

// let's define overloaded numeric operators, e.g. multiplication
def mult(a: Int, b: Int): Int = a * b // this would be implemented at a lower level of course
// and
def mult(a: Double, b: Double): Double = a * b // this would be implemented at a lower level of course

// now I can use the same term, or function name, for both numeric types.
// So, it *looks* like I've achieved something:
mult(a, b)  /*>  6  */
mult(c, d)  /*>  6.9394  */

// but in reality, this doesn't enable generic programming, i.e.
// I can't define say, square once in terms of multiplication
// def square[T](a: T) = mult(a, a)

// the only thing I can do, is continue to define multiple versions of my operators, i.e.
def square(a: Int): Int = mult(a, a)
// and
def square(a: Double): Double = mult(a, a)

// and that's because the overloading is resolved at the point of call.
// if square doesn't know which numeric type it will be acting on, then it doesn't
// know which mult function to choose

// this what one Standard ML does
// and Miranda avoided this problem by having only a single numeric type
