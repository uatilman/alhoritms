package ru.tilman.a06simplesort

class CompareCounter : Number() {
    private val compare: Array<Int> = arrayOf(0)
    operator fun inc(): CompareCounter {
        compare[0]++
        return this
    }

    fun get() = compare[0]
    fun reset() {
        compare[0] = 0
    }

    override fun toByte(): Byte = get().toByte()

    override fun toDouble(): Double  = get().toDouble()

    override fun toFloat(): Float  = get().toFloat()

    override fun toInt(): Int  = get()

    override fun toLong(): Long  = get().toLong()

    override fun toShort(): Short  = get().toShort()
}