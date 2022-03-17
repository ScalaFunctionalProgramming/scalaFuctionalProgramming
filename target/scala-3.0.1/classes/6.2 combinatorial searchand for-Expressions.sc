/* One natural way to generate the sequence of pairs is to:
▶ Generate all the integers i between 1 and n (excluded).
▶ For each integer i, generate the list of pairs (i, 1), ..., (i, i-1).*/
def isPrime (n:Int): Boolean = (2 until n).forall(n%_ !=0)
// hard way
(1 until 5).flatMap(i =>
  (1 until i).map(j => (i, j)))
  .filter((x, y) => isPrime(x + y))


// hard way

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  xs.zip(ys).map((x, y) => x * y).sum

  // simple way

def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
  (for (x, y) <- xs.zip(ys) yield x * y).sum
  //(for x <- xs; y <-ys yield x* y).sum
  // It would multiply every elements of xs with every elements of ys
  // and sum up the results


/* for s yield e
where s is a sequence of generators and filters, and e is an expression
whose value is returned by an iteration.
▶ A generator is of the form p <- e, where p is a pattern and e an
expression whose value is a collection.
▶ A filter is of the form if f where f is a boolean expression.
▶ The sequence must start with a generator.
▶ If there are several generators in the sequence, the last generators
vary faster than the first.*/

//  simple way
for{
  i <- 1 until 7
  j <- 1 until i
  if isPrime(i + j)}
yield (i, j)

case class Person(name:String, age:Int)

//for p <- persons if p.age> 20  yield  p.name
//  persons
//    .filter(p=> p.age > 20)
//    .map( p => p.name)



val data = List(1, 1, 2, 3, 5, 8)

def loopA(values: List[Int]) =
  for x <- values yield x * x

def loopB(values: List[Int]) =
  (0 to (values.size)).map { x =>
    x * x
  }

def loopC(values: List[Int]) =
  values.map(x => x * x)

//def mystery(xs: Seq[Int]) =
//  xs
//    .filter(x => x % 2 == 0)
//    .map(x => x * x)
//    .sum

def mystery(xs: Seq[Int]) =
  val ys =
    for x <- xs
        if x % 2 == 0
    yield x * x
  ys.sum