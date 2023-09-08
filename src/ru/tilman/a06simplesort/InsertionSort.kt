package ru.tilman.a06simplesort

class InsertionSort<T : Comparable<T>>(override val array: Array<T>) : AbstractSort<T>()  {

    override fun sort() {
        for (j in 1 until array.size) {
            var i = j - 1
            while (i >= 0 && more(array[i], array[i + 1])) {
                swap(i, i + 1)
                i--
            }
        }
    }

}