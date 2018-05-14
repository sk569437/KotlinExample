package com.afmobi.sk.demokotlin.kotlin.model

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.afmobi.sk.demokotlin.R
import com.afmobi.sk.demokotlin.kotlin.data_class.PersonBean
import kotlinx.android.synthetic.main.item_moive_layout.view.*
import kotlinx.android.synthetic.main.item_person_layout.view.*

/**
 * Created by sk on 18-5-14.
 */
class PersonAdapter(context: Context, list: ArrayList<PersonBean>?) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    var mContext: Context ?= null
    var mList: ArrayList<PersonBean> ?= null


    init {
        this.mContext = context
        this.mList = list
    }

    fun getItem(i: Int): PersonBean? {
        return mList?.get(i)
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }


    private fun hobbyInit(holder: PersonViewHolder, list: ArrayList<PersonBean.Movie>) {


        with(holder) {
            this.id_layout_hobby?.removeAllViews()

            for(item in list) {
                var view = View.inflate(mContext, R.layout.item_moive_layout, null).apply {
                    id_movie_type.setText(item.movieType)
                    id_movie_charactor.setText(item.mainCharactor)
                }

                var lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                this.id_layout_hobby?.addView(view, lp)
            }
        }
    }

    override fun onBindViewHolder(holder: PersonViewHolder?, position: Int) {

        getItem(position)?.let {

            //var personBean = it
            holder?.run {
                this.id_person_name?.setText(it.name)
                this.id_person_sex?.setText(it.sex)
                this.id_person_age?.setText(it.age.toString())
                this.id_person_hobby?.setText("爱好：")

                hobbyInit(this, it.list!!)
            }

            holder?.also {

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_person_layout, parent, false)
        return PersonViewHolder(view)
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id_person_name = itemView.id_person_name
        var id_person_age = itemView.id_person_age
        var id_person_sex = itemView.id_person_sex
        var id_person_hobby = itemView.id_person_hobby
        var id_layout_hobby = itemView.id_layout_hobby

    }



}