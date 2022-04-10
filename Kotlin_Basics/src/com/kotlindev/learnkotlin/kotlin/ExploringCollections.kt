package com.kotlindev.learnkotlin.kotlin

fun main(args: Array<String>) {

    // create IMMUTABLE list
    val colors = listOf("Red", "Green", "Blue")
    println(colors::class.qualifiedName)

    // create a MUTABLE list
    val days = mutableListOf("Monday", "Tuesday", "Wednesday")
    val numbers = mutableListOf<Int>()

    // create IMMUTABLE set
    val months = setOf("Jan", "Feb")

    // create MUTABLE set
    val monthsMutable = mutableSetOf("Jan", "Feb")

    // create IMMUTABLE map
    val webColors = mapOf("red" to "ff0000", "blue" to "00ff00")

    // if you don't want to provide initial values, you must provide the data types
    val webColorsMutable = mutableMapOf<String, String>()

    // ARRAYS
    // In Kotlin, Arrays are Classes, and act like a collection
    // when we work with arrays, we have get/set methods and an iterator
    // unlike maps, lists, sets...Arrays in Kotlin are ALWAYS MUTABLE, there are NO IMMUTABLE arrays
    // they are of a fixed size

    // IN GENERAL: favor lists over arrays because you get more functionality with them
    // There are some scenarios you might want to be use arrays for performance

    val intArray: IntArray = intArrayOf(1,2,3,4,5)
    intArray.set(3, -4)
    // shortcut to change value
    intArray[3] = -7
    intArray.forEach { println(it) }

    // using square bracket notation in lists as well
    println(colors[2]) // "Blue"
}