package ru.tilman.a06simplesort

import ru.tilman.a09linesort.BucketSort
import ru.tilman.checktasks.Task
import java.text.DecimalFormat
import kotlin.system.measureTimeMillis

class SortTask : Task {
    override fun run(args: Array<String>, isDebug: Boolean): String {
        val initSize = 10
        var sizeStep = initSize

        val sequence = generateSequence(initSize) { it * 10 }.takeWhile { it <= 100_000 }
        for (i in sequence) {
            val arr = setRandom(i)
            val expected = arr.copyOf()

            val internalSortTimeMills = measureTimeMillis { expected.sort() }

            val decimalFormat = DecimalFormat("###,###")
            println("Размер: '${decimalFormat.format(i)}', сравнений: '???', присвоений: '???', время исполнения: '${decimalFormat.format(internalSortTimeMills)} мс'.")

            val actual = executeSort(BucketSort(arr.copyOf()))
            if (isDebug && arr.size <= 100 && !actual.assert(expected)) {
                println()
                println(arr.joinToString())
                println(expected.joinToString())
                println(actual.array.joinToString())
            }

            executeSortAndCheck(BucketSort(arr.copyOf()), expected)
            executeSortAndCheck(BubleSort(arr.copyOf()), expected)
            executeSortAndCheck(InsertionSort(arr.copyOf()), expected)
            executeSortAndCheck(InsertionShiftSort(arr.copyOf()), expected)
            executeSortAndCheck(InsertionBinarySort(arr.copyOf()), expected)
            executeSortAndCheck(ShellSort(arr.copyOf()), expected)

            sizeStep *= 10
        }

        return ""
    }

    private fun <T : Comparable<T>> executeSort(sorter: Sort<T>): Sort<T> =
        sorter.execute().lastSortResult()

    private fun <T : Comparable<T>> executeSortAndCheck(sorter: Sort<T>, expected:Array<T>){
        executeSort(sorter).assert(expected).apply { if (this) println(" Проверка ${sorter.javaClass.simpleName}: 'true'") else System.err.println(" Проверка BucketSort: 'false'") }
    }

}