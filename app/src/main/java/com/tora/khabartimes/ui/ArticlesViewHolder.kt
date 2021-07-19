package com.tora.khabartimes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tora.khabartimes.R
import com.tora.khabartimes.data.model.Result
import com.tora.khabartimes.databinding.ItemArticleBinding


class ArticlesViewHolder(
    private val binding: ItemArticleBinding,
    private val onArticleClick: ((Result) -> Unit)?
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.articleCard.setOnClickListener {
            onArticleClick?.invoke(binding.article!!)
        }

    }

    fun bind(data: Result) {
        val url = data.media.takeIf { !it.isNullOrEmpty() }
            ?.get(0)?.mediaMetadata.takeIf { !it.isNullOrEmpty() }?.get(0)?.url
        binding.article = data
        Glide.with(binding.root)
            .load(url)
            .centerInside()
//        .diskCacheStrategy(DiskCacheStrategy.NONE)
//        .skipMemoryCache(true)
            .placeholder(R.drawable.ic_nytimes_ar21)
            .into(binding.articlePhotoImageview)
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onArticleClick: ((Result) -> Unit)?
        ): ArticlesViewHolder {
            val binding = DataBindingUtil.inflate<ItemArticleBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_article,
                parent,
                false
            )
            return ArticlesViewHolder(
                binding,
                onArticleClick
            )
        }
    }


}
