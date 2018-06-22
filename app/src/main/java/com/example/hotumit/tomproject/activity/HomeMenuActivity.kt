package com.example.hotumit.tomproject.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import com.example.hotumit.mykotlin.adapter.MenuHomeAdapter
import com.example.hotumit.tomproject.MainActivity
import com.example.hotumit.tomproject.R
import com.example.hotumit.tomproject.dao.*
import com.example.hotumit.tomproject.dao.dummydata.MenuGenerator
import com.example.hotumit.tomproject.utility.ClickListener
import com.example.hotumit.tomproject.utility.Contextor
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.view_menu_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeMenuActivity : AppCompatActivity(),ClickListener {

    val post : MutableList<Post> = ArrayList()
    override fun itemClicked(view: View?, position: Int) {
        if (position == 0) {
            startActivity(Intent(this@HomeMenuActivity, MainActivity::class.java))

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_menu_profile)
        initview()
    }

    private fun initview() {
        val layoutManager = GridLayoutManager(Contextor.getInstance().context, 2)
        rvAndroidVersion.layoutManager = layoutManager
        rvAndroidVersion.setHasFixedSize(true)
        val adapter = MenuHomeAdapter(MenuGenerator.createAndroidVersionInfo())
        rvAndroidVersion.adapter = adapter
        adapter.setClickListener(this)

    }




}