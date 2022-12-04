import java.io.File

fun main(){

    val numberOfCommonPairs = File("src/Day04.txt")
        .readText()
        .split("\n")
        .flatMap { it.lines() }
        .sumOf {
            val split = it.split(",")
            overLappingAssignmentPair(split[0].split("-"), split[1].split("-"))
        }

    println(numberOfCommonPairs)

}

fun pairsInRangeOfEachOther(firstPair: List<String>,secondPair: List<String>) : Int{
    val firstPairInsideSecond = firstPair[0].toInt() >= secondPair[0].toInt() && firstPair[1].toInt() <= secondPair[1].toInt()
    val secondPairInsideFirst = secondPair[0].toInt() >= firstPair[0].toInt() && secondPair[1].toInt() <= firstPair[1].toInt()
    return if (firstPairInsideSecond.or(secondPairInsideFirst))
        1
    else
        0
}

fun overLappingAssignmentPair(firstPair: List<String>,secondPair: List<String>) : Int{
    val firstPairOverlappingSecond = firstPair[0].toInt() in secondPair[0].toInt()..secondPair[1].toInt() || firstPair[1].toInt() in secondPair[0].toInt()..secondPair[1].toInt()
    val secondPairOverlappingFirst = secondPair[0].toInt() in firstPair[0].toInt()..firstPair[1].toInt() || secondPair[1].toInt() in firstPair[0].toInt()..firstPair[1].toInt()
    return if (firstPairOverlappingSecond.or(secondPairOverlappingFirst))
        1
    else
        0
}