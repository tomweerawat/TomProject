package com.example.hotumit.tomproject.dao


import com.example.hotumit.tomproject.constant.Conts


class NewPhotoItemDao( id: String,  caption: String,  timestamp: String, var url: String) : Post(id, caption, timestamp, Conts.PHOTO)