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
