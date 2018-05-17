package com.afmobi.sk.demokotlin.kotlin.common

import com.afmobi.sk.demokotlin.kotlin.sigle_instance.LogUtils

/**
 * Created by sk on 18-5-15.
 */
class Derived {


    class BaseImpl(val x: Int): Base {
        override fun print() {
            LogUtils.d(x.toString())
        }
    }

    interface Base{
        fun print()
    }
}