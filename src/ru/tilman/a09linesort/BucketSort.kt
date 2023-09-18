package ru.tilman.a09linesort

import ru.tilman.a06simplesort.AbstractSort

class BucketSort(override val array: Array<Int>) : AbstractSort<Int>() {

    override fun sort() {
        val max = max()
        val divisor = ((max + 1) / array.size) + 1
        val buckets: Array<BucketImp> = Array(array.size) { BucketImp() }

        array.forEach {
            val bucketIndex = it / divisor
            buckets[bucketIndex].add(it)
        }

        var i = 0
        buckets.forEach {
            var bucketElement = it.first
            if (bucketElement != null) {
                array[i++] = bucketElement.value
                while (bucketElement != null && bucketElement.hasNext()) {
                    array[i++] = bucketElement.next().value
                    bucketElement = bucketElement.next()
                }
            }
        }

    }

    private fun max(): Int {
        if (array.isEmpty()) throw IllegalArgumentException("Array is empty")
        var max = array[0]
        array.forEach {
            if (it > max) max = it
            compare++
        }
        return max
    }

    inner class BucketImp {

        var first: BucketElement? = null

        fun add(value: Int) {
            first.also {
                if (it == null) {
                    first = BucketElement(value, null)
                    compare++
                    assignment++
                    return
                }

                var bucketElement: BucketElement = it
                var previous: BucketElement = it
                while (bucketElement.hasNext() && value > bucketElement.next().value) {
                    compare++
                    previous = bucketElement
                    bucketElement = bucketElement.next()
                }

                compare++
                assignment++
                if (value > bucketElement.value) bucketElement.setNext(BucketElement(value, bucketElement.nextOrNull()))
                else if (bucketElement == first) first = BucketElement(value, bucketElement)
                else previous.setNext(BucketElement(value, bucketElement))
            }
        }

        override fun toString(): String {
            if (first == null) return ""
            val builder = StringBuilder()
            var pointer = first
            while (pointer!!.hasNext()) {
                builder.append(pointer.value)
                builder.append(" ")
                pointer = pointer.next()
            }
            builder.append(pointer)
            return builder.toString()
        }

        inner class BucketElement(
            val value: Int,
            private var next: BucketElement?,
        ) {

            fun hasNext(): Boolean = next != null

            fun next(): BucketElement = next ?: throw ArrayIndexOutOfBoundsException()

            fun nextOrNull() : BucketElement? = next

            fun setNext(nextBucketElement: BucketElement) {
                next = nextBucketElement
            }

            override fun toString(): String {
                return value.toString()
            }
        }
    }


}


