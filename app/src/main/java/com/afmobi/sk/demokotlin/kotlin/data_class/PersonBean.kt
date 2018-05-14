package com.afmobi.sk.demokotlin.kotlin.data_class

/**
 * Created by sk on 18-3-5.
 */

data class PersonBean(var name:String, var age:Int, var sex:String, var list: ArrayList<Movie>?) {


    data class Movie(var movieType: String, var mainCharactor: String) {

    }


}