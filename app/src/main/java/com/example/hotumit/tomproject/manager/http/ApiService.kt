package com.example.hotumit.monthlyincome.manager.http



import com.example.hotumit.tomproject.dao.MovieItemDao
import com.example.hotumit.tomproject.dao.PhotoItemCollectionDao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("list")
    fun loadPhotoList(): Call<PhotoItemCollectionDao>

    @GET("movies_2017.json")
    fun loadMovieList():Call<List<MovieItemDao>>

    @POST("list/after/{id}")
    fun loadPhotoListAfterId(@Path("id") id: Int): Call<PhotoItemCollectionDao>

    @POST("list/before/{id}")
    fun loadPhotoListBeforeId(@Path("id") id: Int): Call<PhotoItemCollectionDao>




}
