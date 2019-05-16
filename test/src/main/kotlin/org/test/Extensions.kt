package org.kotlin
// fun MutableList<Int>.swap(index1: Int, index2: Int) {
//     val tmp = this[index1] // 'this' corresponds to the list
//     this[index1] = this[index2]
//     this[index2] = tmp
// }

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

class C {
    val <T> List<T>.lastIndex: Int
        get() = size - 1
    fun foo() { println("member") }
}

fun C.foo() { println("extension") }
fun C.foo1(i: Int) { println("extension") }

fun Any?.toString(): String {
    println(this)
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.foo() { 
    println("companion")
}

open class D { }

class D1 : D() { }

open class C2 {
    open fun D.foo() {
        println("D.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D) {
        d.foo()   // call the extension function
    }
}

class C1 : C2() {
    override fun D.foo() {
        println("D.foo in C1")
    }

    override fun D1.foo() {
        println("D1.foo in C1")
    }
}

fun main() {
    val l = mutableListOf(1, 2, 3)
    l.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'l'
    println(l)

    val c = C()
    c.foo()
    c.foo1(1) 
    c.toString()
    // println(c.lastIndex) //how it works ???

    MyClass.foo()

    C2().caller(D())   // prints "D.foo in C"
    C1().caller(D())  // prints "D.foo in C1" - dispatch receiver is resolved virtually
    C2().caller(D1())  // prints "D.foo in C" - extension receiver is resolved statically
}