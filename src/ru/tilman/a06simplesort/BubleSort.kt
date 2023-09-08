package ru.tilman.a06simplesort

class BubleSort<T : Comparable<T>>(override val array: Array<T>) : AbstractSort<T>() {

    override fun sort() {
        for (j in array.size - 1 downTo 0)
            for (i in 0 until j)
                if (more(array[i], array[i + 1])) swap(i, i + 1)
    }

}