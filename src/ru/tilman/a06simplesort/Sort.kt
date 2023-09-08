package ru.tilman.a06simplesort

interface Sort<T : Comparable<T>> {
    val array: Array<T>
    var assignment: Long
    val compare: CompareCounter
    var executeTime: Long

    fun execute(): Sort<T>
    fun lastSortResult(): Sort<T>
    fun assert(expected: Array<T>): Boolean

}

