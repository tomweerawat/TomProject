package com.example.hotumit.tomproject.dao

import com.akexorcist.listadapter.constant.Conts
import com.google.gson.annotations.SerializedName

data class MovieItemDao(
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String,
    @SerializedName("price") val price: String
):TypeForRecyclerview(Conts.Movie)