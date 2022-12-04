import scala.io.Source

object RucksackReorganiser {
  def openFile(filename: String): String = {
    val dataSource = Source.fromFile(filename)
    val lines: String = dataSource.mkString
    dataSource.close
    lines
  }

  def mostImportantItemTotaller(rucksacks_input: String): Int = {
    val allRucksacks = rucksacks_input.split("\n")
    allRucksacks.map {
      rucksack =>
        val commonItem = findCommonItem(rucksack)
        findItemPriorityValue(commonItem)
    }.sum
  }

  def findCommonItem(rucksack: String): String = {
    val compartmentSize: Int = rucksack.length / 2
    val separatedCompartments: (String, String) = rucksack.splitAt(compartmentSize)
    val commonItem = separatedCompartments._1 intersect separatedCompartments._2
    commonItem.distinct
  }

  def findItemPriorityValue(item: String): Int = {
    val letters = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
      "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
    "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    val numbers: Seq[Int] = 1 to 52
    val priorityValues: Map[String, Int] = (letters zip numbers).toMap
    priorityValues.get(item) match {
      case Some(value) => value
      case None => -500
    }
  }
}
