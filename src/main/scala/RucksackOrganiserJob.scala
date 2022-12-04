object RucksackOrganiserJob extends App {
  val data = RucksackReorganiser.openFile("/Users/curnowl/Developer/AdventOfCode2022/day_3_Rucksack/src/main/scala/rucksack_data.txt")
  val total = RucksackReorganiser.mostImportantItemTotaller(data)
  println(RucksackReorganiser.getElfGroupPriorities(data))
}
