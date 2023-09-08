package ru.tilman.a06simplesort

import ru.tilman.checktasks.Task
import java.text.DecimalFormat
import kotlin.system.measureTimeMillis

class SimpleSortTask : Task {
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

            executeSort(BubleSort(arr.copyOf())).assert(expected).apply { println(" Проверка BubleSort: '$this'") }
            executeSort(InsertionSort(arr.copyOf())).assert(expected).apply { println(" Проверка InsertionSort: '$this'") }
            executeSort(InsertionShiftSort(arr.copyOf())).assert(expected).apply { println(" Проверка InsertionShiftSort: '$this'") }
            executeSort(InsertionBinarySort(arr.copyOf())).assert(expected).apply { println(" Проверка InsertionBinarySort: '$this'") }
            executeSort(ShellSort(arr.copyOf())).assert(expected).apply { println(" Проверка ShellSort: '$this'") }

            sizeStep *= 10
        }

        return ""
    }

    private fun <T : Comparable<T>> executeSort(sorter: Sort<T>): Sort<T> =
        sorter.execute().lastSortResult()


}