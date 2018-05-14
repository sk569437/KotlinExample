package com.afmobi.sk.demokotlin.kotlin.delegate_proxy

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by sk on 18-3-7.
 */
class Preference<T>(val context: Context, val name: String?, val default: T) : ReadWriteProperty<Any?, T>{

    val prefs by lazy { context.getSharedPreferences("xxxx", Context.MODE_PRIVATE) }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = with(prefs){
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var res: Any = when(default) {
            is Int -> {
                getInt(name, default)
            }
            is Long -> {
                 getLong(name, default)
            }
            is Float -> {
                getFloat(name, default)
            }
            is String -> {
                getString(name, default)
            }
            is Boolean -> {
                getBoolean(name, default)
            }
            else -> {
                throw IllegalArgumentException("This is can't be saved into Preference")
            }
        }

        res as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = with(prefs.edit()){
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when(value) {
            is Int -> putInt(name, value)
            is Long -> putLong(name, value)
            is Float -> putFloat(name, value)
            is String -> putString(name, value)
            is Boolean -> putBoolean(name, value)
            else -> {
                throw IllegalArgumentException("This type can't save into Preference.")
            }
        }.apply()
    }
}