import java.util.*

data class KotlinPerson (val id: Long, val title: String, val firstName: String, val surname: String, val dateOfBirth: Calendar?) {

    var favoriteColor: String? = null
    fun getUpperCaseColor(): String {
        // won't work, option is to set variable above and then check variable
        // return if (favoriteColor == null) "" else favoriteColor.uppercase()
        // option 2, use 'elvis operator'
        return favoriteColor?.uppercase() ?: ""
    }

    fun getLastLetter(a: String) = a.takeLast(1)

    fun getLastLetterOfColor(): String {
        // return if (favoriteColor == null) "" else getLastLetter(favoriteColor)
        return favoriteColor?.let { getLastLetter(it)} ?: ""
    }

    // option 1: more verbose if/if else/else
//    fun getColorType(): String {
//        val color = getUpperCaseColor()
//        return if (color == "")
//            "empty"
//        else if (color == "RED" || color == "BLUE" || color == "GREEN")
//            "rgb"
//        else
//            "other"
//    }
    // option 2
    fun getColorType(): String {
        val color = getUpperCaseColor()
        return when (color) {
            "" -> "empty"
            "RED", "GREEN", "BLUE" -> "rgb"
            else -> "other"
        }
    }

    override fun toString() = "$title $firstName $surname"

    companion object {
        fun getAge(dateOfBirth: Calendar?) : Int {
            if (dateOfBirth == null) return -1;
            val today = GregorianCalendar()
            val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
            if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) return years - 1
            return years
        }
    }
    val age: Int
    get() = getAge(dateOfBirth)
    // NOTE: If you need to check for null and you want to return the variable your checking or some fall back
    // you could use the 'elvis operator' return age ?: -1    this says if age is not null, return age, else return -1
}

fun main(args: Array<String>) {
    val john = KotlinPerson(1L, "Mr", "John", "Blue", GregorianCalendar(1977, 9, 3));
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null);
    println("$john's age is ${john.age}")
    println("$jane's age is ${jane.age}")
    println("The age of someone born on 3rd May 1988 is " + KotlinPerson.getAge(GregorianCalendar(1988, 5, 3)));
    val olderPerson = if (john.age > jane.age) john else jane
    println("The older person is $olderPerson")
}