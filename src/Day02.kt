import java.io.File

fun main(){

    val score = File("src/Day02.txt")
        .readText()
        .split("\n")
        .flatMap { it.lines() }
        .map { it.split(" ") }
        .sumOf { getPointOfRoundSecondPart(it[0].first(), it[1].first()) }


    println(score)
}

fun getPointOfRound(first: Char, second: Char): Int {
   return when (second) {
      'X' -> {
          return when (first) {
              'A' -> 1 + 3
              'B' -> 1
              else -> 1 + 6
          }

      }
      'Y' -> {
          return when (first) {
              'A' -> 2 + 6
              'B' -> 2 + 3
              else -> 2
          }
      }
      else -> {
          return when (first) {
              'A' -> 3
              'B' -> 3 + 6
              else -> 3 + 3
          }
      }
    }
}

fun getPointOfRoundSecondPart(first: Char, second: Char): Int {
    return when (second) {
        'X' -> {
            return when (first) {
                'A' -> 3
                'B' -> 1
                else -> 2
            }

        }
        'Y' -> {
            return when (first) {
                'A' -> 1 + 3
                'B' -> 2 + 3
                else -> 3 + 3
            }
        }
        else -> {
            return when (first) {
                'A' -> 2 + 6
                'B' -> 3 + 6
                else -> 1 + 6
            }
        }
    }
}