package com.example.hotumit.tomproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hotumit.tomproject.manager.singleton.HttpManager
import com.example.hotumit.tomproject.R
import com.example.hotumit.tomproject.adapter.DessertAdapter
import com.example.hotumit.tomproject.constant.Conts
import com.example.hotumit.tomproject.dao.CollectionX
import com.example.hotumit.tomproject.dao.DessertItemDao
import com.example.hotumit.tomproject.utility.ClickListener
import com.example.hotumit.tomproject.utility.Contextor
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_cart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CartFragment : Fragment(), ClickListener {
    override fun itemClicked(view: View?, position: Int) {
        Toast.makeText(Contextor.getInstance().context, "Position$position", Toast.LENGTH_SHORT).show()
    }

    val collectionX : MutableList<CollectionX> = ArrayList()
    companion object {

        fun newInstance(param1: String, param2: String): CartFragment {
            val fragment = CartFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    val TAG:String = "CartFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_cart, container, false)

        loadData()


        return rootView
    }

    private fun loadData() {
        val call = HttpManager.DessertService()
        call.loadDessertList(1).enqueue(object: Callback<DessertItemDao?> {
            override fun onResponse(call: Call<DessertItemDao?>?, response: Response<DessertItemDao?>?) {
                val dao = response!!.body()
                val newdao = dao!!.collections
                Log.e(TAG, "Dessert" + GsonBuilder().setPrettyPrinting().create().toJson(newdao))

                for (item in newdao){
                   /* val post1 = NewCollectionX(item.collection.collectionId,item.collection.resCount,item.collection.imageUrl,item.collection.url,item.collection.title,item.collection.description,item.collection.shareUrl)*/
                    val post1 = CollectionX(item.collection.collectionId,item.collection.resCount,item.collection.imageUrl,item.collection.url,item.collection.title,item.collection.description,item.collection.shareUrl)
                    collectionX.add(post1)
                }
                val layoutManager = LinearLayoutManager(Contextor.getInstance().context)
                recyclerView2.layoutManager = layoutManager
                recyclerView2.setHasFixedSize(true)
                val adapter = DessertAdapter(collectionX)
                recyclerView2.adapter = adapter
                adapter.setClickListener(this@CartFragment)
            }

            override fun onFailure(call: Call<DessertItemDao?>?, t: Throwable?) {

            }


        })
    }


}// Required empty public constructor
