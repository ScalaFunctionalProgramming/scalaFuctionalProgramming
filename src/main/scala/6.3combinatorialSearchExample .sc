val fruit = Set("apple", "banana", "pear")
val s =(1 to 6).toSet

s.map(_+ 2)
fruit.filter(_.startsWith("app"))
s.nonEmpty
/*the principal differences between sets and sequences are
* Sets are unordered; elements of a set do not have a predefined order
   in which they appear in the set
* sets do not have duplicate elements
* the fundamental operation on sets is contains
s.contains (5)      //true */


def queens(n:Int) ={
  def placeQueens(k:Int): Set[List[Int]] = {
    if k==0 then Set(List())
    else
      for{queens <- placeQueens(k-1)
          col <- 0 until n
          if isSafe(col, queens)}
      yield col :: queens
  }

  placeQueens(n)
}
def isSafe(col: Int, queens: List[Int]):Boolean = {
  !checks(col, 1, queens)
}
def checks(col:Int, delta:Int, queens: List[Int]):Boolean =queens match {
  case qcol :: others =>
    qcol == col
    || (qcol-col).abs == delta
    || checks (col, delta +1, others)
  case Nil => false
}
/* N-Queens Example
The eight queens problem is to place eight queens on a chessboard so that
no queen is threatened by another.
▶ In other words, there can’t be two queens in the same row, column,
or diagonal.
We now develop a solution for a chessboard of any size, not just 8.
One way to solve the problem is to place a queen on each row.
Once we have placed k - 1 queens, one must place the kth queen in a
column where it’s not “in check” with any other queen on the board.
                  Solution
We can solve this problem with a recursive algorithm:

▶ Suppose that we have already generated all the solutions consisting of
placing k-1 queens on a board of size n.
▶ Each solution is represented by a list (of length k-1) containing the
numbers of columns (between 0 and n-1).
▶ The column number of the queen in the k-1th row comes first in the
list, followed by the column number of the queen in row k-2, etc.
▶ The solution set is thus represented as a set of lists, with one element
for each solution.
▶ Now, to place the kth queen, we generate all possible extensions of
each solution preceded by a new queen:*/
val xs: Seq[Int] = (1 to 10).map(_ => 42)
val ys: Set[Int] = xs.to(Set)
println(xs)
println(ys)