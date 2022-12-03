import java.io.File

fun main(){

    val groupSize = 3

/*    val sumOfPriorities = File("src/Day03.txt")
        .readText()
        .split("\n")
        .flatMap { it.lines() }
        .map { getCommonCharacters(it) }
        .flatMap { it.map { elf -> getPriority(elf) } }
        .sum()

    println(sumOfPriorities)*/

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

fun getCommonCharacters(input: String): List<Char> {
    val compartments = input.chunked(input.length / 2)
    val firstCompartment = compartments[0].toHashSet()
    val secondCompartment = compartments[1].toHashSet()
    firstCompartment.retainAll(secondCompartment)
    return firstCompartment.toList()

}

fun getBadgesFromRuckSacks(ruckSacks: List<String>): Char{
    val first = ruckSacks[0].toHashSet()
    val second = ruckSacks[1].toHashSet()
    val third = ruckSacks[2].toHashSet()
    first.retainAll(second)
    first.retainAll(third)
    return first.first()
}