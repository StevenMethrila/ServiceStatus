package com.sample.servicestatus

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("healthcheck-details")
    fun getEntireData() : Call<List<MyData>>
}