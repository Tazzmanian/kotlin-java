package org.test.Nested

class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
    inner class Inner {
        fun foo() = bar
    }
}


fun main() {
    var demo = Outer.Nested().foo() // == 2
    println(demo)
    demo = Outer().Inner().foo()
    println(demo)
}