import scala.io.Source
@main def solution: Int = {

  // Read our input file
  val source = Source.fromFile("input.txt")

  try {
    // Get each line of the file, create our empty group, and our max number
    val lines = source.getLines()
    var group = Seq.empty[String]
    var maxNumber = Int.MinValue

    for (line <- lines) {

      // If the line is empty, sum the current group
      if (line.isEmpty) {
        if (group.nonEmpty) {
          // Sum group
          val groupSum = group.map(_.toInt).sum
          // Check for new max number
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

    println(maxNumber)
    return maxNumber

  } finally {
    source.close()
  }
}
