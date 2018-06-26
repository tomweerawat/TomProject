package com.example.hotumit.tomproject.dao

import com.example.hotumit.tomproject.constant.Conts
import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("collection") val collection: CollectionX
)