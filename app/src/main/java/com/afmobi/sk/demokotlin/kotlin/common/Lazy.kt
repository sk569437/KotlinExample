package com.afmobi.sk.demokotlin.kotlin.common

/**
 * Created by sk on 18-5-16.
 */
class Lazy {

    val str: String by lazy{
        println("completed")

        "jane"
        "marry"
        "jake"
    }


    fun main(args: Array<String>) {
        println(str)
        println(str)
    }


}