import java.io.File

fun main(){

    val groupSize = 3

    val sumOfPriorities = File("src/Day03.txt")
        .readText()
        .also { println(it) }
        .split("\n")
        .flatMap { it.lines() }
        .map { getCommonCharacters(it) }
        .flatMap { it.map { elf -> getPriority(elf) } }
        .sum()

    println(sumOfPriorities)

    val sunOfPriorities = File("src/Day03.txt")
        .readText()
        .split("\n")
        .chunked(3)
        .map { getBadgesFromRuckSacks(it) }
        .sumOf { getPriority(it)  }

    println(sunOfPriorities)


}

fun getPriority(char: Char): Int {
    return when {
        char.isLowerCase() -> char - 'a' + 1
        char.isUpperCase() -> char - 'A' + 27
        else -> error("Check Input")
    }
}

fun getCommonCharacters(input: String): Set<Char> {

    val (firstCompartment,secondCompartment) = input.chunked(input.length / 2)
    return firstCompartment.toSet() intersect secondCompartment.toSet()

}

fun getBadgesFromRuckSacks(ruckSacks: List<String>): Char{
    val (first, second, third)  = ruckSacks
    return(first.toSet() intersect second.toSet() intersect third.toSet()).single()
}

fun solution1(){
    File("src/Day03.txt")
        .readText()
        .split("\n")
        .flatMap { it.lines() }
        .map { it.chunked(it.length /2) }
        .map { it[0].toSet() intersect it[1].toSet() }
        .sumOf { getPriority(it.first()) }
}
