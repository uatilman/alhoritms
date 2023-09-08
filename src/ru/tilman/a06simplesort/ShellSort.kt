package ru.tilman.a06simplesort

class ShellSort<T : Comparable<T>>(override val array: Array<T>) : AbstractSort<T>() {

    override fun sort() {

        var gap = array.size / 2
        while (gap > 0) {

            var j = gap
            while (j < array.size) {

                var i = j
                while (i >= gap && more(array[i-gap], array[i])) {
                    swap(i - gap, i)
                    i -= gap
                }
                j++

            }

            gap /= 2
        }

    }

}