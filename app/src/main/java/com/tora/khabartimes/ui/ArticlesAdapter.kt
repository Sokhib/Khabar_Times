package com.tora.khabartimes.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tora.khabartimes.data.model.Result

class ArticlesAdapter :
    RecyclerView.Adapter<ArticlesViewHolder>() {

    private val articles: ArrayList<Result> = arrayListOf()
    var onArticleClick: ((Result) -> Unit)? = null

    fun setArticleList(articleList: List<Result>) {
        this.articles.apply {
            clear()
            addAll(articleList)
        }
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticlesViewHolder.create(
            parent,
            onArticleClick
        )

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        return holder.bind(articles[position])
    }
}