package com.tora.khabartimes.ui.mostpopularlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tora.khabartimes.R
import com.tora.khabartimes.data.model.Result
import com.tora.khabartimes.databinding.ItemArticleBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.Holder>() {

    var products = ArrayList<Result>()
//    var productsNewList: MutableList<Result> = mutableListOf()

    init {
//        productsNewList = products
    }

    private lateinit var productClick: (Result) -> Unit
    fun onClickItem(onClick: (Result) -> Unit) {
        this.productClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: ItemArticleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_article,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(products[position], productClick)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class Holder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productsNewList: Result, productClick: (Result) -> Unit) {
            binding.article = productsNewList
            binding.root.setOnClickListener {
                productClick.invoke(productsNewList)
            }
        }
    }

//    override fun getFilter(): Filter {
//
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charSearch = constraint.toString()
//                if (charSearch.isEmpty()) {
//                    productsNewList = products
//                } else {
//                    val resultList: MutableList<Result> = mutableListOf()
////                    for (row in products) {
////                        if (row.name!!.toLowerCase(Locale.ROOT)
////                                .contains(charSearch.toLowerCase(Locale.ROOT))
////                        ) {
////                            resultList.add(row)
////                        }
////                    }
//                    productsNewList = resultList
//                }
//                val filterResults = FilterResults()
//                filterResults.values = productsNewList
//                return filterResults
//            }
//
//            @Suppress("UNCHECKED_CAST")
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                productsNewList = results?.values as MutableList<Result>
//                notifyDataSetChanged()
//            }
//
//        }
//    }
}