package com.kotlindev.learnkotlin.kotlin

import java.math.BigDecimal
import java.util.*

fun main(args: Array<String>) {
    var result: Any

    val randomNumber = Random().nextInt(3)
    if (randomNumber == 1) {
        result = BigDecimal(30)
    } else {
        result = "hello"
    }

    println("Result is currently $result")

    if (result is BigDecimal) {
        // add 47
        // "Smart Casting" in Kotlin (if an explicit type check is done)
        result = result.add(BigDecimal(47))
    } else {
        // put it into uppercase
        // no explicit type check, so need to cast
        val tempResult = result as String
        result = tempResult.uppercase()
    }
    println("Result is currently $result")
}