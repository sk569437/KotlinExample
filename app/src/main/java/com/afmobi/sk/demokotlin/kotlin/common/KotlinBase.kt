package com.afmobi.sk.demokotlin.kotlin.common

import com.afmobi.sk.demokotlin.kotlin.sigle_instance.LogUtils

/**
 * Created by sk on 18-5-15.
 */
class KotlinBase {

    fun testBaseType() {
        var i: Int = 10
        var l1: Long = 10
        var l2: Long = i.toLong()
        var s1: Short = i.toShort()
        var s2: Short = l2.toShort()

        i++
        i.inc()
        println(i.toString())

        //i == l1 // error, 类型不一样
    }
    fun testWhen(param: Any?) {
        val s: String = "abc"

        when(s) {
            is String -> println(s)
            else -> println("s is not string")
        }

        when {
            s.equals("1234") -> println("$s equals 1234")
            s.equals("abc")  -> println("$s equals abc")
            else -> println("s is not equal 1234 or abc")
        }

        when(param) {
            is String -> LogUtils.d("$param is String")
            is Int -> println("$param is Int")
            !is Boolean -> println("$param is not boolean")
            else -> println("#param is boolean")
        }
    }



}