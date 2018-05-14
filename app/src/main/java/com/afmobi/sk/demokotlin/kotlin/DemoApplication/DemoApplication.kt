package com.afmobi.sk.demokotlin.kotlin.DemoApplication

import android.app.Application

/**
 * Created by sk on 18-3-7.
 */
class DemoApplication : Application() {


    companion object {
        lateinit var mInstance : DemoApplication   //lateinit表示这个属性开始是没有值得，但是，在使用前将被赋值（否则，就会抛出异常）
        private set //private set用于说明外部类不能对其进行赋值。
    }

    override fun onCreate() {
        super.onCreate()

        mInstance = this


    }



}