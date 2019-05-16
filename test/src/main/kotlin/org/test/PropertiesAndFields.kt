const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { }

class Address {
    var name: String = "..."
    var street: String = "..."
    var city: String = "..."
    var state: String? = "..."
    var zip: String = "..."
    var allByDefault: Int? // error: explicit initializer required, default getter and setter implied
    var initialized = 1 // has type Int, default getter and setter

    val size = 10
    val isEmpty: Boolean
        get() = this.size == 0

    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            setDataFromString(value) // parses the string and assigns values to other properties
        }
    var setterVisibility: String = "abc"
        private set // the setter is private and has the default implementation

    // var setterWithAnnotation: Any? = null
    //     @Inject set // annotate the setter with Inject

    var counter = 0 // Note: the initializer assigns the backing field directly
    set(value) {
        if (value >= 0) field = value
    }

    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }
    
    

    init {
        allByDefault = 10
    }

    fun setDataFromString(value: String) {

    }

    fun copyAddress(address: Address): Address {
        val result = Address() // there's no 'new' keyword in Kotlin
        result.name = address.name // accessors are called
        result.street = address.street
        // ...
        return result
    }
}

public class MyTest {
    lateinit var subject: Address

    // @SetUp fun setup() {
    //     subject = Address()
    // }

    // @Test fun test() {
    //     // subject.method()  // dereference directly
    // }

    fun initialized() {
        if (this::subject.isInitialized) {
            println("init")
        } else {
            println("not init")
        }
    }
}



fun main() {
    val test = MyTest()
    test.initialized()
}