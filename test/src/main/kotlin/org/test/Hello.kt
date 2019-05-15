package org.test


fun main(args: Array<String>) {
    println("Hello, World")
    // underscoreNumericLiterals();
    // representation1()
    // representation2()
    // expricitCobvertions()
    // characters()
    // arrays()
    // unsigned()
    // strings()
    expressions()
}

fun expressions() {
    ifExpression()
    whenExpression()
    forLoops()
    whileLoop()
}

fun whileLoop() {
    var x = 10
    while (x > 0) {
        x--
        println(x)
    }

    do {
        println("do")
        val y: Int? = retrieveData()
        println("Hi $y")
    } while (y != null) // y is visible here!
}

fun retrieveData(): Int? {
    println("retrieveData")
    return null;
}

fun forLoops() {
    for (i in 1..3) {
        println(i)
    }
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    val array = intArrayOf(1, 2, 3)
    for (i in array.indices) {
        println(array[i])
    }

    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}

fun whenExpression() {
    val x = 1;
    when(x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> {
            println("x is neither 1 nor 2")
        }
    }

    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }

    val s = "1"
    when (x) {
        s.toInt() -> println("s encodes x")
        else -> println("s does not encode x")
    }

    val validNumbers = intArrayOf(1, 2, 3)
    when (x) {
        in 1..10 -> println("x is in the range")
        in validNumbers -> println("x is valid")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }

    println(hasPrefix("prefixes"))
}

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun ifExpression() {
    // Traditional usage 
    val a = 5
    val b = 1
    var max: Int? = a 
    // if (a < b) {
    //     max = b
    // } else {
    //     max = a
    // }
    max = if (a > b) a else b
    println(max) 
    max = if (a > b) {
        println("its a")
        a
    } else {
        println("its b")
        b
    }
}

fun strings() {
    val str = "test"
    for (c in str) {
        println(c)
    }

    val s = "abc" + 1.toString()
    println(s + "def")

    val s1 = "Hello, world!\n"
    print(s1)

    val text = """
        for (c in "foo")
            print(c)
    """
    println(text)

    val text1 = """
        |Tell me and I forget.
        Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
        """.trimMargin()
    println(text1)

    val i = 10
    println("i = $i") // prints "i = 10"

    val s2 = "abc"
    println("$s2.length is ${s2.length}") // prints "abc.length is 3"

    val price = """
        ${'$'}9.99
        """
    println(price)
}

fun unsigned() {
    val b: UByte = 1u  // UByte, expected type provided
    val s: UShort = 1u // UShort, expected type provided
    val l: ULong = 1u  // ULong, expected type provided

    val a1 = 42u // UInt: no expected type provided, constant fits in UInt
    val a2 = 0xFFFF_FFFF_FFFFu // ULong: no expected type provided, constant doesn't fit in UInt

    val a = 1UL // ULong, even though no expected type provided and constant fits into UInt
}

fun arrays() {
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }

    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
}

fun characters() {
    val c: Char = '1'
    if (c.toInt() == 1) { // ERROR: incompatible types
        println("yes")
    } else {
        println("no")
    }
}

fun expricitCobvertions() {
    // Hypothetical code, does not actually compile:
    // var a: Int? = 1 // A boxed Int (java.lang.Integer)
    // var b: Long? = a.toLong() // implicit conversion yields a boxed Long (java.lang.Long)
    // print(b == a) // Surprise! This prints "false" as Long's equals() checks whether the other is Long as well
    val b: Byte = 1 // OK, literals are checked statically
    val i: Int = b.toInt() // ERROR
    val l = 1L + 3 // Long + Int => Long
    val x = (1 shl 2) and 0x000FF000
}

fun underscoreNumericLiterals() {
    val oneMillion = 1_000_000
    println("$oneMillion")
    val creditCardNumber = 1234_5678_9012_3456L
    println("$creditCardNumber")
    val socialSecurityNumber = 999_99_9999L
    println("$socialSecurityNumber")
    val hexBytes = 0xFF_EC_DE_5E
    println("$hexBytes")
    val bytes = 0b11010010_01101001_10010100_10010010
    println("$bytes")
}

fun representation1() {
    val a: Int = 10000
    println(a === a) // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
}

fun representation2() {
    val a: Int = 10000
    println(a == a) // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA == anotherBoxedA) // !!!Prints 'false'!!!
}

