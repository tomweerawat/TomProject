package com.example.hotumit.tomproject

import android.app.Application
import android.content.Context
import com.example.hotumit.tomproject.utility.Contextor




class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Contextor.getInstance().init(applicationContext)

    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }

}
