package com.example.hotumit.tomproject.dao


import com.akexorcist.listadapter.constant.Conts


class NewPhotoItemDao( id: String,  caption: String,  timestamp: String, var url: String) : Post(id, caption, timestamp, Conts.PHOTO)