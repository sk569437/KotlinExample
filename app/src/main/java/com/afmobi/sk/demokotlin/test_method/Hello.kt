package com.afmobi.sk.demokotlin.test_method

import com.afmobi.sk.demokotlin.kotlin.sigle_instance.LogUtils

/**
 * Created by sk on 18-3-2.
 */
class Hello {

    fun say() {
        LogUtils.i("Hello World")
    }

    /**
     * 在 Kotlin 中无返回为 Unit
     *
     * 此方法接收一个无参数的函数并且无返回
     *
     * 使用参数名加 () 来调用
     */
    fun people(hello: () -> Unit) {
        hello()
    }


    fun say(msg: String) {
        LogUtils.i("Hello $msg")
    }


    /**
     * 当调用的函数有形参时，
     * 需要在调用的函数声明，并使用声明的形参；
     * 函数参数中的形参无法使用
     */
    fun people(arg0: String, hello: (arg1: String) -> Unit) {
        hello(arg0) // hello(arg1) 这样调用将报错
    }



}