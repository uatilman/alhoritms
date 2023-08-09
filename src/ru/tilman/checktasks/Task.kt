package ru.tilman.checktasks

interface Task {
    fun run(args: Array<String>, isDebug:Boolean):String
}