package com.example.hotumit.tomproject.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

import com.bumptech.glide.Glide

import com.example.hotumit.tomproject.dao.NewPhotoItemDao

import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_photo_post.*

class PhotoViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(post: NewPhotoItemDao) {
        tvCodeName.text = post.caption
        tvReleaseDate.text = post.timestamp
        Glide.with(containerView.context).load(post.url).into(img)
    }
}