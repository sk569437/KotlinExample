package com.afmobi.sk.demokotlin.kotlin.common

/**
 * Created by sk on 18-5-15.
 */
class KotlinMap {

    val list by lazy {
        ArrayList<Int>().apply {
            add(2)
            add(-4)
            add(0)
            add(-2)
            add(12)
            add(-32)
            add(6)
            add(32)
        }
    }

    fun test1(s:String, s2:String="abc", i1:Int = 1, b: Boolean = false) {

    }


}