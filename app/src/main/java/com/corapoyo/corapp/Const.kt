package com.corapoyo.corapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Const {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:5000/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}