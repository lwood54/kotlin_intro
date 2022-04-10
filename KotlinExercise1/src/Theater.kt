import java.math.BigDecimal

data class Seat(val row: Int, val num: Int, val price: BigDecimal, val description: String) {
    // YOU MAY NOT EDIT THIS CLASS
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}

class Theater {

    // SEAT PRICES:
    // Seats in rows 15 and 15 cost 14.50
    // Seats in rows 1 to 13 and numbered 1 to 3 or 34 to 36 cost 16.50
    // All other seats in row 1 cost 21
    // All others seats cost 18.00

    // SEAT DESCRIPTIONS:
    // Seats in row 15: "Back row"
    // Seats in row 14: "Cheaper set"
    // All other rows, seats 1 to 3 and 34 to 36: "Restricted View"
    // All other seats: "Standard seat"

//    val seats = ArrayList<Seat>()// THIS MUST BE AN IMMUTABLE LIST

    // You can create an Immutable list from a mutable one by doing:
        // val mutableList = ArrayList<String>()
        // val immutableList = mutableList.toList()

    // create a mutable list of seats first
    private val hiddenSeats = mutableListOf<Seat>()
    private fun getPrice(row: Int, col: Int): BigDecimal {
        return when {
            row >= 14 -> BigDecimal(14.50)
            (col in 1..3) || (col in 34..36) -> BigDecimal(16.50)
            row == 1 -> BigDecimal(21)
            else -> BigDecimal(18.00)
        }
    }
    private fun getDescription(price: BigDecimal, row: Int): String {
        return when {
            row == 14 -> "Cheaper seat"
            row == 15 -> "Back row"
            price ==  BigDecimal(16.50) -> "Restricted view"
            row <= 2 -> "Best view"
            else -> "Standard seat"
        }
    }
    constructor() {
    for (row in (1..15)) {
        for (col in (1..36)) {
            val price = getPrice(row, col)
            val newSeat = Seat(row, col, price, getDescription(price, row))
            hiddenSeats.add(newSeat)
        }
    }
    }


    val seats
    get() = hiddenSeats.toList()
}

fun main(args: Array<String>) {
    val cheapSeats = Theater().seats.filter {it.price == BigDecimal(14.50)}
    val frontSeats = Theater().seats.filter {it.price == BigDecimal(21)}
    for (seat in cheapSeats) println(seat)
    for (seat in frontSeats) println(seat)
}