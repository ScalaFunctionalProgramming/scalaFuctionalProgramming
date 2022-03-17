
package ammonite
package $file.src.main.scala
import _root_.ammonite.interp.api.InterpBridge.{
  value => interp
}
import _root_.ammonite.interp.api.InterpBridge.value.{
  exit,
  scalaVersion
}
import _root_.ammonite.interp.api.IvyConstructor.{
  ArtifactIdExt,
  GroupIdExt
}
import _root_.ammonite.compiler.CompilerExtensions.{
  CompilerInterpAPIExtensions,
  CompilerReplAPIExtensions
}
import _root_.ammonite.runtime.tools.{
  browse,
  grep,
  time,
  tail
}
import _root_.ammonite.compiler.tools.{
  desugar,
  source
}
import _root_.mainargs.{
  arg,
  main
}
import _root_.ammonite.repl.tools.Util.{
  PathRead
}


object `6.1 seq collections and its operations`{
/*<script>*/val nums = Vector(1, 2, 3, -88)
val people = Vector("Bob","James" , "peter")
/* they support the same operations as lists, with the exception of
  :: Instead of x :: xs there is
  x +: xs create new vector with x at the beg
  xs :+ x create new vector with x at the end */

/* Arrays and Strings support the same operations as seq and can implicitly be converted to sequences
* where needed
* they cannot be subclasses of Seq because they come from Java*/

val xs: Array[Int] = Array(1, 2, 3)
/*<amm>*/val res_3 = /*</amm>*/xs.map(x => 2 * x)

val ys:String = "Hello World!"
/*<amm>*/val res_5 = /*</amm>*/ys.filter(_.isUpper)

// Range represents a sequence of evenly spaced integers
// it has three operators
// to => inclusive, until => exclusive, by => determine step value

val r: Range= 1 until 5
 /*<amm>*/val res_7 = /*</amm>*/r.foreach(print)
val s: Range = 1 to 5
/*<amm>*/val res_9 = /*</amm>*/s.foreach(print)
/*<amm>*/val res_10 = /*</amm>*/(1 to 10 by 3).foreach(print)

/*Range is represented as a single object with three fields :
* Lower bound
* upper bound
* step value */


/* xs.exists(p) => true if there is an element x of xs such that p(x) holds,
false otherwise.
xs.forall(p)=> true if p(x) holds for all elements x of xs, false otherwise.
xs.zip(ys)=> A sequence of pairs drawn from corresponding elements
of sequences xs and ys.
xs.unzip=> Splits a sequence of pairs xs into two sequences consisting of the first, respectively second halves of all pairs.
xs.flatMap(f)=> Applies collection-valued function f to all elements of
xs and concatenates the results
xs.sum=> The sum of all elements of this numeric collection.
xs.product=> The product of all elements of this numeric collection
xs.max=> The maximum of all elements of this collection (an
Ordering must exist)
xs.min=> The minimum of all elements of this collection
      Example
To list all combinations of numbers x and y where x is drawn from 1..M
and y is drawn from 1..N:
(1 to M).flatMap(x => (1 to N).map(y => (x, y)))

        Example
def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  xs.zip(ys).map((x, y) => x * y).sum
el 3dd el awlee
 def isPrime (n:Int): Boolean = (2 until n).forall(n%_ !=0)

*/
/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "6$u002E1$u0020seq$u0020collections$u0020and$u0020its$u0020operations"
  /*</generated>*/
}
