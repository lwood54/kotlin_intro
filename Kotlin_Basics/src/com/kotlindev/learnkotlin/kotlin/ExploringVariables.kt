package com.kotlindev.learnkotlin.kotlin

import java.math.BigDecimal
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    var name = "Logan" // mutable, given underline as hint
    val surname = "Wood" // immutable
    name = "Tiffany"

    println("Hello $name ${surname.uppercase()}")
    println("Your name is ${name.length} letters long")
    println("Your surname is ${surname.length} letters long")
    println("The \$name variable has length of ${name.length}")

    val multiLineString = """This is a multiline
        |string that I want to
        |indent bla bla bla.
    """.trimMargin("|")
    println(multiLineString)

    val myDouble = 21.4
    println(myDouble is Double)
    println("myDouble is a ${myDouble::class.qualifiedName}")

    println("myDouble's javaClass is ${myDouble.javaClass}")

    val myInteger = myDouble.roundToInt()
    println("myInteger is ${myInteger::class.qualifiedName}")
    println("myInteger's javaClass is ${myInteger.javaClass}")

    val anotherInteger: Int = 17
    val myFloat: Float = 13.6F
    val result = myFloat + anotherInteger
    println("myFloat + anotherInteger = $result")

    val bigDeci: BigDecimal = BigDecimal(17)
    println("bigDeci is ${bigDeci::class.qualifiedName}")

    val bigDeci2: BigDecimal
    println("stuff happens")
    bigDeci2 = bigDeci.add(BigDecimal(30))
    println("bigDeci2 = $bigDeci2")
}