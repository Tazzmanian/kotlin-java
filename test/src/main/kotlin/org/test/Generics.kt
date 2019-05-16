class Box<T>(t: T) {
    var value = t
}

class P {

}


fun main() {
    val box: Box<Int> = Box<Int>(1)
    val box1 = Box(P())
}