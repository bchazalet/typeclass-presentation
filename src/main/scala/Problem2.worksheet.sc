// Problem2: equality

// Let's overload the equality, this is what Standard ML does
def equals(a: Int, b: Int): Boolean = a == b // cheating here

def equals(a: Double, b: Int): Boolean = a == b // cheating here

// now, let's try to write a generic find method on list
// this can't work:
// def contains[T](list: List[T], y: T): Boolean = list match {
//   case Nil => false
//   case x :: xs => if(equals(x, y)) true else contains(xs, y)
// }

// but it works if I only consider Int
// def contains(list: List[Int], y: Int): Boolean = list match {
//   case Nil => false
//   case x :: xs => if(equals(x, y)) true else contains(xs, y)
// }

// instead, let's try to give equals a polymorphic type
