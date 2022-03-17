/* A map of type Map[key,value] is a data structure
 that associates keys of type key with values of type value */
val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalOfCountry= Map("US" -> "Washington", "Switzerland" -> "Bern")
val countryOfCapital = capitalOfCountry.map ((x, y) => (y,x))
val cap1 = capitalOfCountry.withDefaultValue("<unknown>")
print("Andorra")
print(capitalOfCountry("US")) //Washington
print(capitalOfCountry.get("US")) //Some(Washington)
print(capitalOfCountry.get("Andorra")) //None
print(capitalOfCountry("Andorra")) //java.util.NoSuchElementException: key not found: Andorra


//trait Option[+A]
//case class Some[+A](value: A) extends Option[A]
//object None extends Option[Nothing]

def showCapital(country: String) = capitalOfCountry.get(country) match
  case Some(capital) => capital
  case None => "missing data"

/*Functional updates of a map are done with the + and ++ operations:
m + (k -> v) The map that takes key ‘k‘ to value ‘v‘
                and is otherwise equal to ‘m‘
m ++ kvs     The map ‘m‘ updated via ‘+‘ with all key/value
              pairs in ‘kvs‘
These operations are purely functional. For instance,

val m1 = Map(”red” -> 1, ”blue” -> 2) > m1 = Map(red -> 1, blue -> 2)
val m2 = m1 + (”blue” -> 3) > m2 = Map(red -> 1, blue -> 3)
m1 > Map(red -> 1, blue -> 2)*/
val m1 = Map("red" -> 1, "blue" -> 2) // m1 = Map(red -> 1, blue -> 2)
val m2 = m1 + ("blue" -> 3) // m2 = Map(red -> 1, blue -> 3)
print(m1) // Map(red -> 1, blue -> 2)
print(m2) // Map(red -> 1, blue -> 3) over ride the value

val fruit = List("apple", "pear", "orange", "pineapple")
fruit.sortWith(_.length < _.length) // List(”pear”, ”apple”, ”orange”, ”pineapple
fruit.sorted // List(”apple”, ”orange”, ”pear”, ”pineapple
fruit.groupBy(_.head)
Map(0 -> 5, 1 -> -2, 3-> 1) //x^3 -2x +5

class Polynom(nonZeroTerm: Map[Int, Double]):
  def this(bindings: (Int, Double)*) = this(bindings.toMap)

  def terms = nonZeroTerm.withDefaultValue(0.0)
  def + (other: Polynom) :Polynom=
      Polynom(other.terms.foldLeft(terms)(addTerm))
  def addTerm(terms: Map[Int, Double], term: (Int, Double)) =
    val (exp,coeff) = term
    terms + (exp -> (terms(exp) + coeff))
    //Polynom(terms ++ other.terms.map((exp,coeff) => (exp, terms(exp) + coeff)))

  override def toString: String ={
    val termString =
      for(exp, coeff) <- terms.toList.sorted.reverse
        yield
          val exponent = if exp ==0 then ""
          else s"x^$exp"

          s"$coeff$exponent"
    if terms.isEmpty then "0"
    else termString.mkString(" + ")
  }



val x = Polynom( 0 -> 2, 1 -> 3, 2-> 1)
val z = Polynom()
x+x+z

val ageOfPeople =
  Map("Alice" -> 7, "Bob" -> 11, "Carol" -> 13)
val ageOfPeople2 =
  ageOfPeople ++ Map("Ted" -> 10, "Alice" -> 8)
val ageOfPeople3 =
  ageOfPeople.map((name, age) => (name, age + 1))

println(ageOfPeople.get("Alice"))  // (1)
println(ageOfPeople.get("Ted"))    // (2)
println(ageOfPeople2.get("Alice")) // (3)
println(ageOfPeople3.get("Bob"))   // (4)
println(ageOfPeople3("Ted"))       // (5)