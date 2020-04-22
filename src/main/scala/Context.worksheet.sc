// you can only have pure data, i.e.
case class Mydata(a: Int, b: String)

// and pure functions
val myFunction: Int => Int = _ * 3  /*>  <function1>  */

// but MyData doesn't have any method at all. Not even accessors,
// you can only pattern match.
val myFunctionOnMyData: Mydata => Int = _ match {
  case Mydata(a, b) => myFunction(a)
}  /*>  <function1>  */

// and you certainly can't call .multiply or .equals on it

// but you can do parametric polymorphism a.k.a generics
// ML already does it and it's well understood at that point
// so you can write the following
def head[T](list: List[T]): Option[T] = list match {
  case Nil => None
  case x :: xs => Some(x)
}

// Note: polymorphic functions (as opposed to methods) are coming in scala 3!
// val head[T]: List[T] => Option[T] = _ match {
//   case Nil => None
//   case x :: xs => Some(x)
// }
