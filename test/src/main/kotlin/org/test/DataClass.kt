package org.test.dc

data class Person1(val name: String) {
    var age: Int = 0

    constructor(name: String, age: Int):this(name) {
        this.age = age
    }

    fun copy(name: String = this.name, age: Int = this.age) = Person1(name, age)
}

data class Person2(val name: String, val age: Int) {
    // fun copy(name: String = this.name, age: Int = this.age) = Person2(name, age)
}

fun main() {
    val person = Person1("test")
    println(person)
    val jack = person.copy("jack", 10)
    println(jack)
    println(jack.age)

    val (name) = jack
    println("$name, ${jack.age} years of age")

    val jane = Person2("jane", 10)
    println(jane)
}

