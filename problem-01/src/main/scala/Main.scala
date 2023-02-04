import scala.io.Source
@main def solution: Unit = {

  // Read our input file
  val source = Source.fromFile("input.txt")

  try {
    // Get each line of the file, create our empty group, and our max number
    val lines = source.getLines()
    var group = Seq.empty[String]
    var sums = Seq.empty[Int]
    var maxNumber = Int.MinValue

    for (line <- lines) {

      // If the line is empty, sum the current group
      if (line.isEmpty) {
        if (group.nonEmpty) {
          // Sum group
          val groupSum = group.map(_.toInt).sum
          // Check for new max number
          sums :+= groupSum
          if (groupSum > maxNumber) {
            maxNumber = groupSum
          }
          // Reset group
          group = Seq.empty[String]
        }
      } else {
        // Add line to current group
        group :+= line
      }
    }

    // Answer for part 1
    println(maxNumber)
    // ANser for part 2
    println(sums.sorted.takeRight(3).sum)

  } finally {
    source.close()
  }
}
