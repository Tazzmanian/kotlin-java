package org.test.delegation

interface Base {
    val message: String
    fun print()
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() { println(x) }
    override fun printMessage() { println(x) }
    override fun printMessageLine() { println(x) }
}

class Derived(b: Base) : Base by b {
    // This property is not accessed from b's implementation of `print`
    override val message = "Message of Derived"
    override fun printMessage() { println("abc") }
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
    Derived(b).printMessage()
    Derived(b).printMessageLine()
    val derived = Derived(b)
    derived.print()
    println(derived.message)
}