package com.example.hotumit.tomproject.dao.dummydata

import com.example.hotumit.tomproject.dao.MenuItemDao

object MenuGenerator {

    fun createAndroidVersionInfo(): MutableList<MenuItemDao> {
        return arrayListOf(
                MenuItemDao(txt = "Picture"),
                MenuItemDao(txt = "Movie"),
                MenuItemDao(txt = "All"),
                MenuItemDao(txt = "Dummy")


        )
    }
}