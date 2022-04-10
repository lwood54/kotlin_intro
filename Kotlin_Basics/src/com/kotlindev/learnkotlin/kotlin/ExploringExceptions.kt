package com.kotlindev.learnkotlin.kotlin

import java.io.FileInputStream

// @Throws provides checked exception if Java program calls Kotlin function
// not needed if only using in Kotlin code
@Throws (InterruptedException::class)
fun divide(a: Int, b: Int): Double {
    Thread.sleep(1000)
    return (a.toDouble() / b)
}

fun printFile() {
    val input = FileInputStream("file.txt")
    // Kotlin equivalent of 'try with resources'
    input.use {
        // an exception could be thrown here
        // ensures the 'input' object is automatically closed
    }
}

fun main(args: Array<String>) {
//    try {
//        println(7/0)
//    } catch (e: ArithmeticException) {
//        println("Caught $e")
//    }

    // TRY/CATCH is an expression and can be set to a variable
    val result = try {
        divide(5, 23)
    } catch (e: Exception) {
        0
    }
    println(result)
}