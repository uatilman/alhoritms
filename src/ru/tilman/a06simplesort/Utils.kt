package ru.tilman.a06simplesort

import java.security.SecureRandom


fun setRandom(size: Int): Array<Int> {
    val random = SecureRandom()
    return Array(size) {
        random.nextInt(10)
    }
}

fun <T : Comparable<T>> Array<T>.binarySearchRecursion(searched: T, low: Int, high: Int, compare: CompareCounter): Int {
    if (high <= low)
        return if (searched >= get(low)) low + 1 else low
    val middleIndex = (low + high) / 2
    compare.inc()

    return if (searched > get(middleIndex)) binarySearchRecursion(searched, middleIndex + 1, high, compare)
    else binarySearchRecursion(searched, low, middleIndex - 1, compare)

}


//не доделано
/*fun <T : Comparable<T>> Array<T>.binarySearch(searched: T, from: Int, to: Int, compare: CompareCounter): Int {
    var low = from
    var high = to
    if (high <= low)
        return if (searched >= get(low)) low + 1 else low

    var result = -1
    var middleIndex = 0

    while (high >= low) {
        middleIndex = (low + high) / 2
        val middleElement = get(middleIndex)
//        println("high: '$high', low: '$low', middleIndex: '$middleIndex', middleElement: $middleElement")
        compare.inc()
        if (searched == middleElement) {
            result = middleIndex + 1
            break
        } else if (searched > middleElement) low = middleIndex + 1
        else if (searched < middleElement) high = middleIndex - 1
        else {
            result = middleIndex
            break
        }
        if (result == -1) result = middleIndex

    }
    return result
}*/
