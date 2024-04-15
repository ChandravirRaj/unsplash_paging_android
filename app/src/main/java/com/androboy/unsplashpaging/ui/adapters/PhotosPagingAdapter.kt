package com.androboy.unsplashpaging.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.androboy.unsplashpaging.R
import com.androboy.unsplashpaging.ui.model.UnsplashPhoto
import com.androboy.unsplashpaging.utils.imgloading.ImageLoader


class PhotosPagingAdapter() :
    PagingDataAdapter<UnsplashPhoto, PhotosPagingAdapter.QuotePagingViewHolder>(COMPARATOR) {
    private var imgLoader: ImageLoader? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotePagingViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_item, parent, false)
        return QuotePagingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuotePagingViewHolder, position: Int) {
        val item = getItem(position)
        if (imgLoader != null) {
            imgLoader?.DisplayImage(item?.urls?.regular, holder.ivPhotos);
        }
    }

    fun setImageLoader(imgLoader: ImageLoader) {
        this.imgLoader = imgLoader
    }

    class QuotePagingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivPhotos = itemView.findViewById<AppCompatImageView>(R.id.ivMain)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UnsplashPhoto, newItem: UnsplashPhoto
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}