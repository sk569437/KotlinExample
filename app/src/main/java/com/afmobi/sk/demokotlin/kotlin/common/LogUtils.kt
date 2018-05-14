package com.afmobi.sk.demokotlin.kotlin.common

import android.util.Log

/**
 * Created by sk on 18-3-2.
 */
class LogUtils {

    companion object {
        val TAG : String = "DemoKotlin"

        fun d(s:String) {
            Log.d(TAG, s)
        }

        fun i(s:String) {
            Log.i(TAG, s)
        }
    }




}