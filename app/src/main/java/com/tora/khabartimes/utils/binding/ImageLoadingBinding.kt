package com.tora.khabartimes.utils.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.tora.khabartimes.R

@BindingAdapter("url")
fun loadImage(imageView: ImageView, url: String?) {
    if (url.isNullOrEmpty()) {
        return
    }
    Glide.with(imageView.context)
        .load(url)
        .centerInside()
//        .diskCacheStrategy(DiskCacheStrategy.NONE)
//        .skipMemoryCache(true)
        .placeholder(R.drawable.ic_nytimes_ar21)
        .into(imageView)
}