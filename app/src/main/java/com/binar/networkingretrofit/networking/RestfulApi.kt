package com.binar.networkingretrofit.networking

import com.binar.networkingretrofit.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("news")
    fun getAllNews():Call<List<ResponseDataNewsItem>>

}