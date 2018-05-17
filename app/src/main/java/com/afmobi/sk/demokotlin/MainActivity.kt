package com.afmobi.sk.demokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.afmobi.sk.demokotlin.kotlin.common.Child
import com.afmobi.sk.demokotlin.kotlin.common.KotlinBase
import com.afmobi.sk.demokotlin.kotlin.container_operator.Containers
import com.afmobi.sk.demokotlin.kotlin.delegate_proxy.Preference
import com.afmobi.sk.demokotlin.kotlin.method_extension.Animal
import com.afmobi.sk.demokotlin.kotlin.method_extension.newIntent
import com.afmobi.sk.demokotlin.kotlin.nonsafeoperator.nullSafeOperator
import com.afmobi.sk.demokotlin.kotlin.sigle_instance.LogUtils
import com.afmobi.sk.demokotlin.test_method.Hello
import org.jetbrains.anko.custom.async

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
    }

    fun test() {
        testMethod()

        testNullSafeOperator()

        testAnimal()

        testContainerOperator()

        KotlinBase().testBaseType()

        Child("aaa")
    }

    fun testMethod() {
        var noParamCls = Hello()
        noParamCls.people { noParamCls.say() }
        noParamCls.people({ noParamCls.say() })

        var paramCls = Hello()
        paramCls.people { paramCls.say("hello world") }
        paramCls.people ({ paramCls.say("hello world") })
    }

    fun testNullSafeOperator() {
        var nullSafePointer = nullSafeOperator()
        nullSafePointer.testNullSafeOperator(null)
        nullSafePointer.testNullSafeOperator("123456789")
        nullSafePointer.testNullSafeOperator("abc")
        nullSafePointer.testNullSafeOperator("")
    }

    fun Animal.updateInformation(iname:String, isex: String, ilegs: Int, iage: Int) {
        this.name = iname
        this.sex = isex
        this.legs = ilegs
        this.age = iage
    }

    fun testAnimal() {
        var dog = Animal("Dog")
        with(dog) {
            sex = "Female"
            legs = 4
            age = 3

            dog
        }.print()

        run(){
            dog.updateInformation("BlackDog", "Male", 4, 8)

            dog
        }.print()

        dog.let {
            it.updateInformation("WhiteDog", "Female", 4, 9)
            it.print()
        }
    }



    fun testContainerOperator() {
        LogUtils.d("test container operator")
        var container: Containers = Containers()

        container.toString()

        (0 until container.list.size)
                .map { container.list.get(it) }
                .filter { it.sex?.equals("男") }
                .forEach { it.sex = "女" }

        container.toString()

        val ii by Preference(this, "name", "zhangsan")
        LogUtils.d(ii)

        //test anko lib
        async {
            runOnUiThread {
                val view = findViewById<View>(R.id.id_tv_text)
                if (view is TextView) {
                    view.setText("abc")
                    view.setOnClickListener { newIntent<PersonActivity>() }
                }
            }
        }

    }
}
