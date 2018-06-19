package com.example.hotumit.tomproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import butterknife.BindView
import com.example.hotumit.tomproject.adapter.ContentAdapter
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import com.example.hotumit.tomproject.R.id.recyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.hotumit.tomproject.dao.*
import kotlinx.android.synthetic.main.bottom_sheet.*


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ContentAdapter
 /*   val users : PhotoItemCollectionDao? = null
    val users: MutableList<PhotoItemCollectionDao>? = null
 var users : PhotoItemCollectionDao? = null*/

    val post : MutableList<Post> = ArrayList()

    private lateinit var sheetBehavior: BottomSheetBehavior<*>
    private var layoutBottomSheet: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        initBottomSheet()

        btnRefresh.setOnClickListener {
            toggleBottomSheet()
        }
    }

    private fun initBottomSheet() {
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btnRefresh!!.text = "Close Sheet"
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btnRefresh!!.text = "Expand Sheet"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }

    fun toggleBottomSheet() {
        if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            btnRefresh!!.text = "Close sheet"
        } else {
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            btnRefresh!!.text = "Expand sheet"
        }
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
