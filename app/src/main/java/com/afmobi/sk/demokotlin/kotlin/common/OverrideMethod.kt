package com.afmobi.sk.demokotlin.kotlin.common

/**
 * Created by sk on 18-5-16.
 */

class OverrideMethod {

    open class Person {
        open val x: Int get(){ return 12 }
        open fun study() {
            println("我毕业了")
        }
    }

    class Student: Person() {
        override val x: Int = 6
        override fun study() {
            //super.study()
            println("我的读大学")
        }
    }

    fun main(args: Array<String>) {
        val s = Student()
        s.study()
        println("s.x=$s.x")
    }
}