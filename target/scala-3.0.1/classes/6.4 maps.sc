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