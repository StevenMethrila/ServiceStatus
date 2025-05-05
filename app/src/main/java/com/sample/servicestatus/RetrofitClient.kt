package com.sample.servicestatus

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://164.52.215.109:44376/" // Replace with your API base URL

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Method to provide a Retrofit instance
    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }
}


