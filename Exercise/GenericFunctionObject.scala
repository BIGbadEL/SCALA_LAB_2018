package Exercise

object GenericFunctionObject extends App {

  class Arg
  class DerivedArg extends Arg

  class Res
  class DerivedRes extends Res

  def f1(x: Arg): DerivedRes = {
    println("f1")
    new DerivedRes
  }

  def f2(x: DerivedArg) : Res = {
    println("f2")
    new Res
  }

  def f3(x: DerivedArg): DerivedRes = {
    println("f3")
    new DerivedRes
  }

  def f4(x: Arg): DerivedRes = {
    println("f4")
    new DerivedRes
  }

}
