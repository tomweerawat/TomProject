package com.example.hotumit.tomproject.dao

import com.google.gson.annotations.SerializedName
data class PhotoItemCollectionDao(
        @SerializedName("success") val success: Boolean,
        @SerializedName("data") val data: ArrayList<PhotoItemDao>
)