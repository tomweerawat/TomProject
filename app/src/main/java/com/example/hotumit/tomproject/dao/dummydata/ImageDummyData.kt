package com.example.hotumit.tomproject.dao.dummydata


import com.example.hotumit.tomproject.R

import java.util.ArrayList

object ImageDummyData {


    val data: List<Int>
        get() {
            val list = ArrayList<Int>()
            list.add(R.drawable.book)
            list.add(R.drawable.money)
            list.add(R.drawable.calendar)
            list.add(R.drawable.cloud)

            return list
        }


}
