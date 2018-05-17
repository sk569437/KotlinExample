package com.afmobi.sk.demokotlin.kotlin.common

/**
 * Created by sk on 18-5-15.
 */
class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar   //内部类拥有外部类的一个对象引用：
    }

    class Inner2 {
        //fun foo() = bar    //error,内部类不能访问外部类属性
    }
}

//val demo = Outer().Inner().foo() //==1