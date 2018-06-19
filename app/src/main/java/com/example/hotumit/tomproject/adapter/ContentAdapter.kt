package com.example.hotumit.tomproject.adapter


import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.akexorcist.listadapter.constant.Conts

import com.example.hotumit.tomproject.viewholder.PhotoViewHolder
import com.example.hotumit.tomproject.viewholder.StatusViewHolder
import com.example.hotumit.tomproject.R
import com.example.hotumit.tomproject.dao.NewPhotoItemDao
import com.example.hotumit.tomproject.dao.NewStatusPost
import com.example.hotumit.tomproject.dao.Post

class ContentAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(PostDiffCallback()) {


    override fun getItemViewType(position: Int): Int {
    /*  if (position%2==0){
          Log.e("position", "position" + position)


      }else{
          return getItem(position).type
      }*/
        return getItem(position).type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        Conts.STATUS -> StatusViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_status_post, parent, false)) as RecyclerView.ViewHolder
        Conts.PHOTO -> PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_photo_post, parent, false)) as RecyclerView.ViewHolder
        else -> throw NullPointerException("View holder for type $viewType not found")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is StatusViewHolder) {
            val statusPost = getItem(position) as NewStatusPost
            holder.bind(statusPost)
        } else if (holder is PhotoViewHolder) {
            val photoPost = getItem(position) as NewPhotoItemDao
            holder.bind(photoPost)
        }
    }
}