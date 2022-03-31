package com.kotlindev.learnkotlin.kotlin

// OLD WAY: closest to Java
//class Customer {
// Can do old way (instead create constructor by passing parameters to the class
//    val name: String = "Logan"
//    val address: String = "123 Soap St"
//    var age: Int = 39
//
//    constructor(name: String, address: String, age: Int) {
//        this.name = name
//        this.address = address
//        this.age = age
//    }

// if you only need to instantiate a class
//class Customer (val name: String, val address: String, var age: Int)

// constructor as parameters and body if you want to do stuff
class Customer (val name: String, val address: String, var age: Int) {

    // can create a secondary constructor that does not require all fields in class
    constructor(name: String, age: Int) : this(name, "", age) {
        println("secondary constructor")
    }

    // NOTE: if you have a secondary constructor and you still want to perform logic for the main constructor
    // you do that inside init{}
    init {
        println("init block")
    }
}

class AlternativeCustomer (val name: String, var age: Int) {
    var address: String

    init {
        address = "2468 Place Rd"
    }

    constructor(name: String, address: String, age: Int) : this(name, age) {
        this.address = address
    }
}

// Version 3, pass default to address results in essentially the same as version 1
// so you can instantiate a new class with either 2 or 3 arguments
class AnotherAltCustomer (val name: String, var age: Int, val address: String = "")

class CustomerVersion4 (val name: String, var age: Int, val address: String = "") {
    var approved: Boolean = false
    set(value) {
        if (age >= 21) {
            field = value
        } else {
            println("You can't approve a customer under 21 years old.")
        }
    }
// NOTE: could also add a getter
//    get() {
//        return field
//    }

    val nextAge
    get() = age + 1

    // NOTE: if you want to be able to destructure the data, but haven't used the data keyword for your class, you can do this...
    // this is another thing done by default with 'data class ...'
    operator fun component1() = name
    operator fun component2() = age

    fun upperCaseName() : String {
        return name.uppercase()
    }

    // to override a function, you don't use annotation
    override fun toString(): String {
        return "$name $address $age"
    }

    // unlike Top Level Functions, functions inside classes are not static by default
    // to make them static, you do...
    companion object {
        fun getInstance() = CustomerVersion4("Millie", 2, "1122 Hound Dr")
    }
}

data class DataCustomer (val name: String, var age: Int, val address: String = "")

fun main(args: Array<String>) {
    val customer = Customer("Logan", "123 Soap St", 39)
    customer.age = 40
    println("${customer.name} is ${customer.age} years old")

    val customer2 = Customer("Tiffany", 38)
    println("${customer2.name} is ${customer2.age} years old")

    val customer3 = AnotherAltCustomer("Amrynn", 10)
    println("${customer3.name} is ${customer3.age} years old")

    val customer4 = CustomerVersion4("Eisley", 10)
    customer4.approved = true
    println("${customer4.name} is ${customer4.age} years old and...approved? ${customer4.approved}")
    customer4.age = 25
    customer4.approved = true
    println("${customer4.name} is ${customer4.age} years old and...approved? ${customer4.approved}")
    println("Next year, ${customer4.name} will be ${customer4.nextAge} years old.")
    println(customer4.upperCaseName())
    println(customer4.toString())

    val customer4Instance = CustomerVersion4.getInstance()
    println("${customer4Instance.name} is ${customer4Instance.age} years old @ ${customer4Instance.address}")

    val dataCustomer = DataCustomer("Rich", 45)
    println(dataCustomer)
    val copyDataCustomer = dataCustomer.copy(name="Evan")
    println(copyDataCustomer)

    // NOTE: if you are using a 'data' class, then by default you get the ability to destructure the data
    // you can do this without a data class, but not by default
    val (name, age, address) = copyDataCustomer
    println(age)
}