package com.afmobi.sk.demokotlin.kotlin.sigle_instance

import android.util.Log

/**
 * Created by sk on 18-3-7.
 */
object LogUtils {

    private val TAG: String = "KotlinTag"

    fun d(s: String) {
        Log.d(TAG, s)
    }

    fun e(s: String) {
        Log.e(TAG, s)
    }

    fun i(s: String) {
        Log.i(TAG, s)
    }


}