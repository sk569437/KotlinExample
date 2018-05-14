package com.afmobi.sk.demokotlin.kotlin.method_extension

import com.afmobi.sk.demokotlin.kotlin.common.LogUtils

/**
 * Created by sk on 18-3-2.
 */
open class Animal(var name: String) {

//    var name: String ?= null
    var legs: Int = 0
    var age: Int = 0
    var sex: String ?= null


    fun print() {
        LogUtils.d("Animal information, name is $name, is $sex, have $legs legs, and is $age years old")
    }

    open fun eat(s: String) {
        LogUtils.d("Animal $name eating $s")
    }
}