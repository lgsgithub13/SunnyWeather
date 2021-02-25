package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServicesCreator {
    val BASE_URL="https://api.caiyunapp.com/"
    val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    fun <T> create(serviceClass:Class<T>)= retrofit.create(serviceClass)
   inline fun <reified T> create()= create(T::class.java)
}