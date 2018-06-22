package com.example.hotumit.mykotlin.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.akexorcist.listadapter.constant.Conts
import com.example.hotumit.tomproject.R
import com.example.hotumit.tomproject.adapter.viewholder.MenuViewHolder
import com.example.hotumit.tomproject.adapter.viewholder.MovieViewHolder
import com.example.hotumit.tomproject.dao.MenuItemDao
import com.example.hotumit.tomproject.dao.MovieItemDao
import com.example.hotumit.tomproject.dao.dummydata.ImageDummyData
import com.example.hotumit.tomproject.utility.ClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_item_menu.view.*


class MovieAdapter(private val androidList: List<MovieItemDao>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        public lateinit var clicklistener: ClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.e("ViewType","ViewType"+viewType)
        if (viewType == Conts.Movie) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.store_item_row, parent, false)
            return MenuViewHolder(view)
        }
        throw NullPointerException("View holder for type $viewType not found")
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is MovieViewHolder) {
            (holder as MovieViewHolder).bind(androidList[position])
           /* (holder as MenuViewHolder).bind(androidList!![position])*/
        }
    }

    override fun getItemCount(): Int {
        return androidList.size
    }
    override fun getItemViewType(position: Int): Int {

        return androidList[position].type
    }
    fun setClickListener(listener: ClickListener) {
        clicklistener = listener
    }
}