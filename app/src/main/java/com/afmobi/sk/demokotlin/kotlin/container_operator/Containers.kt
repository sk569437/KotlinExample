package com.afmobi.sk.demokotlin.kotlin.container_operator

import com.afmobi.sk.demokotlin.kotlin.common.LogUtils
import com.afmobi.sk.demokotlin.kotlin.data_class.PersonBean

/**
 * Created by sk on 18-3-5.
 */
class Containers {

    var list : ArrayList<PersonBean> = ArrayList<PersonBean>()


    fun Containers() {
        var tv1 = PersonBean("张三", 24, "男", null)
        var tv2 = PersonBean("李四", 34, "男", null)
        var tv3 = PersonBean("万六", 45, "男", null)

        with(list) {
            list.add(tv1)
            list.add(tv2)
            list.add(tv3)
        }

    }


    override fun toString():String {
        var text:String = ""
        for (pb in list) {
            text += "${pb.name} 的年龄是${pb.age}，性别是${pb.sex}.\n"

        }

        LogUtils.d(text)
        return text
    }


//    public void filterPerson()
//    {
//        for (int i = 0; i < list.size(); i++) {
//        PersonBean pb = list.get(i);
//        if (pb != null && pb.name != null && pb.name.equals("男")) {
//            pb.name="女";
//        }
//    }

}