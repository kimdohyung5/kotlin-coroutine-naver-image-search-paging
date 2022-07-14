package com.kimdo.myimagesearchwithxml.ui

import android.util.Log
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kimdo.myimagesearchwithxml.model.Item

class ImageSearchAdapter( private val like: (Item) -> Unit)
    : PagingDataAdapter<Item, ImageSearchViewHolder>(comparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder {
        return ImageSearchViewHolder.create(like, parent)
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val item = getItem(position )
        holder.bind(item)
    }

    companion object {
        val comparator = object: DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                Log.d("kimdo", "comparator: "+(oldItem.thumbnail == newItem.thumbnail).toString())
                return oldItem.thumbnail == newItem.thumbnail
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                Log.d("kimdo","comparator1: "+(oldItem == newItem).toString())
                return oldItem == newItem
            }
        }
    }


}