// Problem2: equality

// Let's overload the equality, this is what Standard ML does
def equals(a: Int, b: Int): Boolean = a == b // cheating here

def equals(a: Double, b: Double): Boolean = a == b // cheating here

// now, let's try to write a generic find method on list
// this can't work:
// def contains[T](list: List[T], y: T): Boolean = list match {
//   case Nil => false
//   case x :: xs => equals(x, y) || contains(xs, y)
// }

// but it works if I only consider Int
// def contains(list: List[Int], y: Int): Boolean = list match {
//   case Nil => false
//   case x :: xs => equals(x, y) || contains(xs, y)
// }

// instead, let's try to give equals a polymorphic type, that's what Miranda does
// def equals[T](a: T, b: T): Boolean = ??? // implemented by the language itself

// the problem with this is that equality is well defined for functions (it raised
// an error at runtime) and for abstract types (which is problematic too).
