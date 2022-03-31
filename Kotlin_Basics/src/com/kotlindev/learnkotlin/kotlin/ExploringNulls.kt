package com.kotlindev.learnkotlin.kotlin

fun main(args: Array<String>) {
    var name: String? = null

//    name = "Logan"
    println(name?.uppercase())

    // CAUTION: this is the only way to actually get a null pointer exception
    // this is telling the compiler, I promise this value won't be null, so if it is, will throw a null pointer exception
    println(name!!.uppercase())

    var address = null // This will be a 'Nothing' class
}