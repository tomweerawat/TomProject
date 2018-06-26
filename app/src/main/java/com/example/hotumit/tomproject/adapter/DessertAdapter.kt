package com.example.hotumit.tomproject.adapter


import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import com.example.hotumit.tomproject.R
import com.example.hotumit.tomproject.adapter.viewholder.DessertViewHolder
import com.example.hotumit.tomproject.adapter.viewholder.MovieViewHolder
import com.example.hotumit.tomproject.adapter.viewholder.PhotoViewHolder
import com.example.hotumit.tomproject.adapter.viewholder.StatusViewHolder
import com.example.hotumit.tomproject.constant.Conts
import com.example.hotumit.tomproject.dao.CollectionX
import com.example.hotumit.tomproject.dao.NewPhotoItemDao

import com.example.hotumit.tomproject.utility.ClickListener



class DessertAdapter(private val androidList: MutableList<CollectionX>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        public lateinit var dessertclicklistener: ClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == Conts.Dessert) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
            return DessertViewHolder(view)
        }else if (viewType == Conts.PHOTO) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article_featured, parent, false)
            return DessertViewHolder(view)
        }

        throw NullPointerException("View holder for type $viewType not found")

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DessertViewHolder) {
            holder.bind(androidList[position])
        }
    }

    override fun getItemCount(): Int {
        return androidList.size
    }
    override fun getItemViewType(position: Int): Int {
        Log.e("DessertViewType","DessertViewType"+position)
        if (position==0){
            return Conts.PHOTO
        }
        else{
            return androidList[position].type
        }

    }
    fun setClickListener(listener: ClickListener) {
        dessertclicklistener = listener
    }
}