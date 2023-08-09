package ru.tilman.a01happytickets

import ru.tilman.checktasks.Task

/**
 * Время написания 2 часа
 * Счастливые билеты 20
 *
 * Билет с 2N значным номером считается счастливым,
 * если сумма N первых цифр равна сумме последних N цифр.
 * Посчитать, сколько существует счастливых 2N-значных билетов.

 * Начальные данные: число N от 1 до 10.
 * Вывод результата: количество 2N-значных счастливых билетов.
 * */
class CountHappyTickets : Task {
    override fun run(args: Array<String>, isDebug: Boolean): String {
        return counter(args[0].toInt() * 2, isDebug).toString()
    }

    private fun getNextArray(previousArray: Array<Long>): Array<Long> {
        val nextLength = previousArray.size + 9
        val nextArray = Array(nextLength) { 0L }
        for (i in 0 until nextLength) {
            var sum = 0L
            for (j in 0 until 10) {
                if (i - j >= 0 && i - j < previousArray.size) sum += previousArray[i - j]
            }
            nextArray[i] = sum
        }

        return nextArray
    }

    private fun counter(length: Int, isDebug: Boolean): Long {
        var result: Long = 0L
        var data = Array(10) { 1L }
        for (i in 0 until length / 2 - 1) {
            data = getNextArray(data)
        }
        data.forEach {

            result += (it * it)
        }
        if (isDebug) println(data.joinToString("\t\t", "SUM:\t"))
        if (isDebug) println(data.joinToString("\t\t", "SQR:\t") { (it * it).toString() })
        return result
    }

}