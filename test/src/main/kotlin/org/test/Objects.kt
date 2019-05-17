package org.test.objects

// object expression
open class A(x: Int) {
    public open val y: Int = x
}

interface B { }

class C {
    // Private function, so the return type is the anonymous object type
    private fun foo() = object {
        val x: String = "x"
    }

    // Public function, so the return type is Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // Works
        // val x2 = publicFoo().x  // ERROR: Unresolved reference 'x'
    }
}

// object declaration
object DataProviderManager {
    fun registerDataProvider(provider: Int) {
        // ...
    }

    val allDataProviders: Int
        get() = 1
}

// companion object
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

interface Factory<T> {
    fun create(): T
}

class MyClass1 {
    companion object : Factory<MyClass1> {
        override fun create(): MyClass1 = MyClass1()
    }
}


fun main() {
    val ab: A = object : A(1), B {
        override val y = 15
    }

    println(ab.y)

    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)

    val instance = MyClass.create()

    val f: Factory<MyClass1> = MyClass1
}