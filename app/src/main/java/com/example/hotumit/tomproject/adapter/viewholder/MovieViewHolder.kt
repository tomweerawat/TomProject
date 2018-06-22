package com.example.hotumit.tomproject.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide


import com.example.hotumit.mykotlin.adapter.MenuHomeAdapter.Companion.clicklistener
import com.example.hotumit.tomproject.dao.MenuItemDao
import com.example.hotumit.tomproject.dao.MovieItemDao


import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.store_item_row.*
import kotlinx.android.synthetic.main.view_item_menu.*
import kotlinx.android.synthetic.main.view_photo_post.*


class MovieViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer, View.OnClickListener  {
    private var view: View = itemView


    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (clicklistener != null) {
            clicklistener.itemClicked(p0, getAdapterPosition())


        }
    }
    fun bind(post: MovieItemDao) {
        title.text = post.title
        price.text = post.price
        Glide.with(containerView.context).load(post.image).into(thumbnail)


    }
}