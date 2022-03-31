package com.kotlindev.learnkotlin.kotlin

// 'Top Level Functions' are public static by default
// impossible to make them non-static, but can be made private
fun printAString(value: String) {
    println(value)
}
// If you wanted a private Top Level Function
// Can only reference this function within the same FILE, not package
private fun privatePrintAString(value: String) {
    println(value)
}

// Java Version
//public double addTwoNumbers(double one, double two) {
//    return one + two;
//}
//fun addTwoNumbers(one: Double, two: Double): Double {
//    return one.plus(two)
//}
// Can do a single expression function, compiler can infer return type with single expression function
fun addTwoNumbers(one: Double, two: Double) = one + two

// Using 'Named Parameters'
// NOTE: If you used Named Parameters, you must provide a name for EVERY parameter, can't mix named and unnamed (unless you provide default values, see below)
fun printSomeMath(one: Double, two: Double) {
    println("one + two is ${one + two}")
    println("one - two is ${one - two}")

    fun funcInAFunc(a: String) {
        println(a)
    }
    funcInAFunc("cool func")
}

// Kotlin does not use overloaded functions as in Java, but instead can have optional parameters (like Javascript)
// NOTE: can use only one default, or multiple defaults. But if you use multiple defaults, and you want to pass the value
// to only the second parameter and use the default for the first parameter, then you need to use a named parameter
fun addTwoNumbersWithDefaults(one: Double = 5.4, two: Double = 9.5) = one + two

// passing a lambda as a parameter
fun funcTakesALambda(input: String, action: (String) -> Int) {
    println(action(input))
}

fun main(args: Array<String>) {
    printAString("Hello world")
    println(addTwoNumbers(5.4, 9.5)) // 14.9
    printSomeMath(two = 5.4,one = 9.5)
    println(addTwoNumbersWithDefaults(two = 10.0)) // 15.4
}