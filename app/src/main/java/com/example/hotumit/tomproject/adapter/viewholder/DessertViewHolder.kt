package com.example.hotumit.tomproject.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide


import com.example.hotumit.mykotlin.adapter.MenuHomeAdapter.Companion.clicklistener
import com.example.hotumit.tomproject.adapter.DessertAdapter.Companion.dessertclicklistener
import com.example.hotumit.tomproject.dao.CollectionX


import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_article.*




class DessertViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer, View.OnClickListener  {
    private var view: View = itemView


    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (dessertclicklistener != null) {
            dessertclicklistener.itemClicked(p0, getAdapterPosition())


        }
    }
    fun bind(post: CollectionX) {
        tv_title.text = post.title
        tv_time.text = post.resCount.toString()
        Glide.with(containerView.context).load(post.imageUrl).into(iv_cover)


    }
}