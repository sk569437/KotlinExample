package com.afmobi.sk.demokotlin.kotlin.sigle_instance

import android.util.Log

/**
 * Created by sk on 18-3-7.
 */
object LogUtil {


    fun d(s: String) {
        Log.d(LogUtil.javaClass.simpleName, s)
    }


}