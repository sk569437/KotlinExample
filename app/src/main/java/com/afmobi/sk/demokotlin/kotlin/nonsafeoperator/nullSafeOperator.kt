package com.afmobi.sk.demokotlin.kotlin.nonsafeoperator

import com.afmobi.sk.demokotlin.kotlin.sigle_instance.LogUtils

/**
 * Created by sk on 18-3-2.
 */
class nullSafeOperator {

    fun testNullSafeOperator(s: String ?) {
        LogUtils.d(s?.toCharArray()?.getOrNull(10)?.hashCode().toString())
    }

}