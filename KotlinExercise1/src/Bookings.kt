import java.math.BigDecimal

interface BookingManager {

    val version: String

    fun isSeatFree(seat: Seat): Boolean
    fun reserveSeat(seat: Seat, customerID: Long): Boolean

    // can provide default implementation
    fun systemStatus() = "All Operations are Functional"
}

// 'open' keyword required if you want to 'extend' this class
// all classes in Kotlin are final by default, but can be switched wih 'open' keyword
open class BasicBookingManager(authorizationKey: String): BookingManager {
    override val version = "1.0"

    override fun isSeatFree(seat: Seat) = true
    override fun reserveSeat(seat: Seat, customerID: Long) = false

    init {
        if (authorizationKey != "12345") throw UnauthorizedUserException()
    }
}

// Extending a class looks similar to implementing an interface
// : Name, but when extending a class, you need to call its constructor and passing
// in any required parameters

// can only extend one class, but can implement multiple interfaces with ' , '
class AdvancedBookingManager: BasicBookingManager("12345"), java.io.Closeable {
    override val version = "2.0"

    fun howManyBookings() = 10

    // now that we are implementing Closeable, need to provide a method for close
    override fun close() {
        TODO("Not yet implemented")
    }
}

// can create a one line custom exception type
class UnauthorizedUserException: Throwable()

// creates a function (option 1) that can upper case the first letter,
// but you can also add a method to the String Class or any class
// option 2
fun String.toTitleCase(): String {
    // NOTE: this being done to the String Class now allows the use of
    // this method from String anywhere in the package
    return this[0].uppercase() + this.substring(1)
}

// option 1
//fun toTitleCase(str: String): String {
//    return str[0].uppercase() + str.substring(1)
//}

fun main(args: Array<String>) {
    println(AdvancedBookingManager().isSeatFree(Seat(1,1, BigDecimal.ZERO, "")))

    val myList = mutableListOf<Int>()

    val greeting = "hi there Kotlin world"
    println(greeting.toTitleCase())
}