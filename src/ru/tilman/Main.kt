package ru.tilman

import ru.tilman.a01happytickets.CountHappyTickets
import ru.tilman.a06simplesort.SortTask
import ru.tilman.checktasks.Tester


fun main(args: Array<String>) {
    SortTask().run(emptyArray(), false)

    val countHappyTickets = CountHappyTickets()
    if (args.isEmpty()) return
    val path = args[0]
    val isDebug = args.size >= 2 && args[1] == "true"
    val tester = Tester(countHappyTickets, path, isDebug)
    tester.runTests()



}