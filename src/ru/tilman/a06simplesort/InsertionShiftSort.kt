package ru.tilman.a06simplesort

class InsertionShiftSort<T : Comparable<T>>(override val array: Array<T>) : AbstractSort<T>() {

    override fun sort() {
        var i: Int
        for (j in 1 until array.size) {
            val current = array[j]
            assignment++

            i = j - 1
            while (i >= 0 && more(array[i], current)) {
                array[i + 1] = array[i]
                assignment++
                i--
            }
            array[i + 1] = current
            assignment++
        }
    }

}