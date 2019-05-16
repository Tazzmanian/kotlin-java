package org.test

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)
    
    init {
        println("First initializer block that prints ${name}")
    }
    
    val secondProperty = "Second property: ${name.length}".also(::println)
    
    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Person(name: String) {
    var name: String = ""
    var children: MutableList<Person> = ArrayList()

    init {
        println("Init block")
        this.name = name
    }

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}

class DontCreateMe private constructor () {
}

open class Base(p: Int) {
    open fun v() { }
    fun nv() { }
}

class Derived(p: Int) : Base(p) {
    constructor(p: Int, x: Int):this(p) {

    }

    override fun v() { }
}

open class AnotherDerived() : Base(5) {
    final override fun v() { }
}

class View {
    // constructor(x: Int) {

    // }
}

// class Derived1(p: Int) : View {
//     constructor(p: Int, x: Int):Base(p) {

//     }
// }

open class Foo {
    open val x: Int get() { return 1 }
}

class Bar1 : Foo() {
    override val x: Int = 1
}

open class Foo1 {
    open fun f() { println("Foo.f()") }
    open val x: Int get() = 1
}

class Bar2 : Foo1() {
    override fun f() { 
        super.f()
        println("Bar.f()") 
    }
    
    override val x: Int get() = super.x + 1

    inner class Baz {
        fun g() {
            super@Bar.f() // Calls Foo's implementation of f()
            println(super@Bar.x) // Uses Foo's implementation of x's getter
        }
    }
}

open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // interface members are 'open' by default
    fun b() { print("b") }
}

class C() : A(), B {
    // The compiler requires f() to be overridden:
    override fun f() {
        super<A>.f() // call to A.f()
        super<B>.f() // call to B.f()
    }
}

open class Base3 {
    open fun f() {}
}

abstract class Derived4 : Base3() {
    override abstract fun f()
}

fun main() {
    InitOrderDemo("hello")
    var person = Person("Teo")
    println(person.name)
}