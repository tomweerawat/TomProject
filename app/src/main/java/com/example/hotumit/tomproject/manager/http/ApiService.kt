package com.example.hotumit.monthlyincome.manager.http



import com.example.hotumit.tomproject.dao.PhotoItemCollectionDao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("list")
    fun loadPhotoList(): Call<PhotoItemCollectionDao>


    @POST("list/after/{id}")
    fun loadPhotoListAfterId(@Path("id") id: Int): Call<PhotoItemCollectionDao>

    @POST("list/before/{id}")
    fun loadPhotoListBeforeId(@Path("id") id: Int): Call<PhotoItemCollectionDao>


}
