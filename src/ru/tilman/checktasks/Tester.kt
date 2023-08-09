package ru.tilman.checktasks

import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists


/**
 *
 * Время написания 30 минут
 *
 * */
class Tester(
    private val task: Task,
    private val path: String,
    private val isDebug: Boolean,
) {
    fun runTests() {
        var counter = 0


        while (true) {
            val inFile = Path("${path}test.${counter}.in")
            val outFile = Path("${path}test.${counter}.out")
            if (!inFile.exists() || !outFile.exists()) return
            println("Test ${counter}. Result: ${runTest(inFile, outFile)}")
            counter++
        }
    }

    private fun runTest(inFile: Path, outFile: Path): Boolean {
        return try {
            val inData = Files.readAllLines(inFile)
            val expectedData = String(Files.readAllBytes(outFile)).trim()
            val actualData = task.run(inData.toTypedArray(), isDebug)
            if (isDebug) println("expected: $expectedData; actual: $actualData")
            expectedData == actualData
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}