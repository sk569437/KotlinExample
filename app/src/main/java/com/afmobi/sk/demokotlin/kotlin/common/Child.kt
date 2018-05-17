package com.afmobi.sk.demokotlin.kotlin.common

/**
 * Created by sk on 18-5-16.
 */
class Child() : Base() {

    var tt: T ?= null

    object tt2: T {//对象声明

    }

    constructor(s: String) : this() {
        tt = object :T{
        }

        tt2.printT()
        val i = label@ tt?.apply {
            printT()
        }
    }


    interface T{
        fun printT() {
            (1..4).forEach label@ {
                if(it == 2) {
                    return@label
                }else{
                    print(it)
                }
            }
        }
    }

}