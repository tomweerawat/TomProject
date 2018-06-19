package com.example.hotumit.tomproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.hotumit.tomproject.adapter.ContentAdapter
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.hotumit.tomproject.dao.*


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ContentAdapter
 /*   val users : PhotoItemCollectionDao? = null
    val users: MutableList<PhotoItemCollectionDao>? = null
 var users : PhotoItemCollectionDao? = null*/

    val post : MutableList<Post> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    fun loadData(){
        val call = HttpManager.ApiService()
        call.loadPhotoList().enqueue(object: Callback<PhotoItemCollectionDao?> {
            override fun onResponse(call: Call<PhotoItemCollectionDao?>?, response: Response<PhotoItemCollectionDao?>?) {
                val dao = response?.body()

                setupRecyclerview(dao)
                genPhoto(dao)

            }

            override fun onFailure(call: Call<PhotoItemCollectionDao?>?, t: Throwable?) {

            }


        })
    }

    private fun genPhoto(dao: PhotoItemCollectionDao?) {

        for (item in dao!!.data){
            val post1 = NewPhotoItemDao(item.id.toString(),item.caption,item.createdTime,item.imageUrl)
            val post2 = NewStatusPost(item.id.toString(),item.caption,item.createdTime)
            post.add(post1)
            post.add(post2)
        }
        Log.e("testtest","testtest"+ post)

    }

    private fun setupRecyclerview(dao: PhotoItemCollectionDao?) {

        var dataList = dao?.data
      /*  Log.e("dataList","dataList"+ GsonBuilder().setPrettyPrinting().create().toJson(dataList))*/

        Log.e("dataList", "dataList$dataList")
     /*   adapter = InfoAdapter(dao)*/
        adapter = ContentAdapter()
        adapter.submitList(post)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


}
