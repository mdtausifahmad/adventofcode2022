import java.io.File

fun main() {
    println(getSumOfThreeHighestCalories())
}


fun getSumOfThreeHighestCalories() : Int {
    return File("src/Day01_test.txt")
        .readText()
        .split("\n\n")
        .map { it.lines().sumOf { it.toInt() } }
        .sortedDescending()
        .take(3)
        .sum()



}
