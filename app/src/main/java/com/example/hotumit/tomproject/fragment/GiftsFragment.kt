package com.example.hotumit.tomproject.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import com.example.hotumit.mykotlin.adapter.MovieAdapter
import com.example.hotumit.tomproject.R
import com.example.hotumit.tomproject.dao.MovieItemDao
import com.example.hotumit.tomproject.utility.Contextor
import kotlinx.android.synthetic.main.fragment_gifts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GiftsFragment : Fragment() {
    var data : List<MovieItemDao> = ArrayList()

    private lateinit var adapter: MovieAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_gifts, container, false)

        loadData()


        return rootView
    }



    fun loadData() {
        val call = HttpManager.MovieService()
        call.loadMovieList().enqueue(object: Callback<List<MovieItemDao>?> {
            override fun onFailure(call: Call<List<MovieItemDao>?>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<MovieItemDao>?>?, response: Response<List<MovieItemDao>?>?) {
               data = response!!.body()!!
                val layoutManager = GridLayoutManager(Contextor.getInstance().context, 2)
                recyclerView1.layoutManager = layoutManager
                recyclerView1.setHasFixedSize(true)
                val adapter = MovieAdapter(data)
                recyclerView1.adapter = adapter

            }
        })
    }

    private fun setupData(data: List<MovieItemDao>) {
     /*   post?.add(dao)
        *//*Log.e("asdf","asdf"+ GsonBuilder().setPrettyPrinting().create().toJson(post))*//*

        Log.e("MyPost","MyPost"+post)
        adapter = MovieAdapter()
        adapter.submitList(post)
        *//*recyclerView.layoutManager = LinearLayoutManager(Contextor.getInstance().context,LinearLayoutManager.HORIZONTAL,false)*//*
        recyclerView1.layoutManager = LinearLayoutManager(Contextor.getInstance().context)
        recyclerView1.adapter = adapter*/




    }


    companion object {

        fun newInstance(param1: String, param2: String): GiftsFragment {
            val fragment = GiftsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
