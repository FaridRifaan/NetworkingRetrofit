package com.binar.networkingretrofit.networking

import com.binar.networkingretrofit.model.DataNews
import com.binar.networkingretrofit.model.ResponseAddNews
import com.binar.networkingretrofit.model.ResponseDataNewsItem
import com.binar.networkingretrofit.model.ResponseUpdateNews
import retrofit2.Call
import retrofit2.http.*

interface RestfulApi {
    @GET("news")
    fun getAllNews():Call<List<ResponseDataNewsItem>>

    @POST("news")
    fun postDataNews(@Body request: DataNews): Call<ResponseAddNews>

    @PUT("news/{id}")
    fun updateDataNews(
        @Path("id") id: Int,
        @Body request: DataNews
    ): Call<List<ResponseUpdateNews>>


}