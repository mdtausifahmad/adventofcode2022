import java.io.File

fun main(){

    val groupSize = 3

    val sumOfPriorities = File("src/Day03.txt")
        .readText()
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

    val compartments = input.chunked(input.length / 2)
    val firstCompartment = compartments[0].toSet()
    val secondCompartment = compartments[1].toSet()
    return firstCompartment intersect secondCompartment

}

fun getBadgesFromRuckSacks(ruckSacks: List<String>): Char{
    val first = ruckSacks[0].toSet()
    val second = ruckSacks[1].toSet()
    val third = ruckSacks[2].toSet()
    return(first intersect second intersect third).single()
}