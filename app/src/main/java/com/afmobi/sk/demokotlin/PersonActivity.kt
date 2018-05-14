package com.afmobi.sk.demokotlin

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.afmobi.sk.demokotlin.kotlin.data_class.PersonBean
import com.afmobi.sk.demokotlin.kotlin.model.PersonAdapter
import kotlinx.android.synthetic.main.activity_person.*
import org.jetbrains.anko.toast

/**
 * Created by sk on 18-5-14.
 */
class PersonActivity : Activity() {


    var mAdapter: PersonAdapter ?= null

    val mList by lazy {
        ArrayList<PersonBean>().apply {
            var movie1 = PersonBean.Movie("动作", "吴京")
            var movie2 = PersonBean.Movie("喜剧", "洪金宝")
            var movie3 = PersonBean.Movie("爱情", "徐铮")
            var list = arrayListOf<PersonBean.Movie>(movie1, movie2, movie3)
            var p = PersonBean("张三", 25, "F", list)
            add(p)


            movie1 = PersonBean.Movie("爱情", "古天乐")
            movie2 = PersonBean.Movie("动作", "洪金宝")
            list = arrayListOf<PersonBean.Movie>(movie1, movie2)
            p = PersonBean("李四", 33, "M", list)
            add(p)


            movie1 = PersonBean.Movie("爱情", "江疏影")
            movie2 = PersonBean.Movie("喜剧", "王宝强")
            movie3 = PersonBean.Movie("警匪", "刘德华")
            list = arrayListOf<PersonBean.Movie>(movie1, movie2, movie3)
            p = PersonBean("陈六", 29, "M", list)
            add(p) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        initView()

        val result = "testLet".also {
            println(it.length)
            1000
        }
        Log.e("DemoKotlin", result)

    }

    private fun initView() {
        with(btn_filter_1) {
            setText(R.string.txt_filter_1)
            setTextColor(Color.BLUE)
            setTextSize(16f)
            setBackgroundResource(R.drawable.selector_btn_background)
            setOnClickListener {
                var list = mList?.filter {
                    it.age > 30
                }

                mAdapter?.let {
                    it.mList = list as ArrayList<PersonBean>
                    it.notifyDataSetChanged()
                }

                this@PersonActivity.applicationContext.toast("${getString(R.string.txt_filter_1)} 有 ${mAdapter?.itemCount} 个")
            }
        }

        with(btn_filter_2) {
            setText(R.string.txt_filter_2)
            setTextColor(Color.BLUE)
            setTextSize(16f)
            setBackgroundResource(R.drawable.selector_btn_background)
            setOnClickListener {
                var list = mList?.filter {
                    it.age < 30 && it.sex.equals("F")
                }

                mAdapter?.let {
                    it.mList = list as ArrayList<PersonBean>
                    it.notifyDataSetChanged()
                }

                it.context.toast("${getString(R.string.txt_filter_2)} 有 ${mAdapter?.itemCount} 个")
            }
        }


        //recyclerview
        var list: ArrayList<PersonBean> = ArrayList<PersonBean>().apply {
            addAll(mList)
        }

        mAdapter = PersonAdapter(this, list)
        var lm = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        with(id_recyclerview) {
            setLayoutManager(lm)
            setAdapter(mAdapter)
        }

    }

}