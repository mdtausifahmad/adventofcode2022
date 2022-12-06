import java.io.File

fun main(){

    val windowSize = 14

    val toList = File("src/Day06.txt")
        .readText()
        .windowed(windowSize)
        .takeWhile { !it.uniqueCharacters() }
        .count()

    val marker = windowSize + toList

    println(marker)


}

fun String.uniqueCharacters(): Boolean = this.toCharArray().distinct().count() == this.length