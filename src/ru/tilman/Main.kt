package ru.tilman

import ru.tilman.a02happytickets.CountHappyTickets
import ru.tilman.checktasks.Tester


fun main(args: Array<String>) {
    val countHappyTickets = CountHappyTickets()
    if (args.isEmpty()) return
    val path = args[0]
    val isDebug = args.size >= 2 && args[1] == "true"
    val tester = Tester(countHappyTickets, path, isDebug)
    tester.runTests()
}