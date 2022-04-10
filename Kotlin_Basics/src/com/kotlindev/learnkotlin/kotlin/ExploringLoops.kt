package com.kotlindev.learnkotlin.kotlin

import KotlinPerson

fun main(args: Array<String>) {
//    var x: Int = 0
//    while( x < 10) {
//        println(x)
//        x++
//    }

    // with ArrayList
//    val people = ArrayList<KotlinPerson>()
//    people.add(KotlinPerson(1, "Mr", "Logan", "Wood", null))
//    people.add(KotlinPerson(2, "Mrs", "Tiffany", "Wood", null))
//    people.add(KotlinPerson(3, "Miss", "Amrynn", "Wood", null))
//    people.add(KotlinPerson(4, "Miss", "Eisley", "Wood", null))
//    for (person in people) {
//    for ((id, title, firstName) in people) {
//        println("$title $firstName has id $id")
//    }

    // with HashMap
    val people = HashMap<Int, KotlinPerson>()
    people[1] = KotlinPerson(1, "Mr", "Logan", "Wood", null)
    people[2] = KotlinPerson(2, "Mrs", "Tiffany", "Wood", null)
    people[3] = KotlinPerson(3, "Miss", "Amrynn", "Wood", null)
    people[4] = KotlinPerson(4, "Miss", "Eisley", "Wood", null)

//    people.put(1, KotlinPerson(1, "Mr", "Logan", "Wood", null))
//    people.put(2, KotlinPerson(2, "Mrs", "Tiffany", "Wood", null))
//    people.put(3, KotlinPerson(3, "Miss", "Amrynn", "Wood", null))
//    people.put(4, KotlinPerson(4, "Miss", "Eisley", "Wood", null))

    for ((key, value) in people) {
        println("$value has key $key")
    }

    // range instead of for loop (which is not available in Kotlin)
    for (i in 0..9) {
        println(i)
    }

    println("range going up with forEach")
    (0..15).forEach { println(it)}
    println("------------")

    println("range going down")
    (10 downTo 0).forEach { println(it) }
    println("------------")

    println("range up 'until'. as in, stops before")
    (0 until 9).forEach { println(it) }
    println("------------")

    println("range with specified step amount")
    (0..9 step 2).forEach { println(it) }
    println("------------")

    println("range of letters")
    ('A'..'F').forEach { println(it) }
}
