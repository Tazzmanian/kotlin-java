package org.test.delegated.properties

import kotlin.reflect.KProperty
import kotlin.properties.Delegates

class Example {
    var p: String by Delegate()

    override fun toString() = "Example Class"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
        
    }
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

class User {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("${prop.name} -> $old -> $new")
    }
}

class User1(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main() {

    val e = Example()
    println(e.p)
    e.p = "NEW"
    println(e.p)

    println(lazyValue)
    println(lazyValue)

    val user = User()
    user.name = "first"
    user.name = "second"

    val user1 = User1(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))

    println(user1.name) // Prints "John Doe"
    println(user1.age)  // Prints 25
}
