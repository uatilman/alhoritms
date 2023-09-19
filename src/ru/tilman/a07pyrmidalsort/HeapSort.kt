package ru.tilman.a07pyrmidalsort

import ru.tilman.a06simplesort.AbstractSort

class HeapSort<T : Comparable<T>>(override val array: Array<T>) : AbstractSort<T>() {
    private val n = array.size
    override fun sort() {
        for (h in n / 2 - 1 downTo 0 step 1) {
            heapify(h, n)
        }

        for (j in n - 1 downTo 1 step 1) {
            swap(0, j)
            heapify(0, j)
        }

    }
    private fun heapify(root: Int, size: Int) {
        var x = root
        val right = 2 * x + 1
        val left = 2 * x + 2
        if (left < size && array[left] > array[x]) x = left
        if (right < size && array[right] > array[x]) x = right
        if (x == root) return
        swap(root, x)
        heapify(x, size)

    }


}