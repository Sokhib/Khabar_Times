package com.tora.khabartimes.ui.articledetail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.tora.khabartimes.R
import com.tora.khabartimes.base.BaseFragment
import com.tora.khabartimes.databinding.ArticleDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailFragment :
    BaseFragment<ArticleDetailViewModel, ArticleDetailFragmentBinding>(R.layout.article_detail_fragment) {

    private val articleViewModel: ArticleDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        backButtonClick()
        observeArticle()
    }

    private fun backButtonClick() {
        binding!!.backFrame.setOnClickListener {
            navigateUp()
        }
    }

    private fun observeArticle() {
        articleViewModel.article.observe(viewLifecycleOwner, { article ->
            binding!!.article = article
            val url = article.media.takeIf { !it.isNullOrEmpty() }
                ?.get(0)?.mediaMetadata.takeIf { !it.isNullOrEmpty() }?.get(0)?.url

            Glide.with(requireActivity())
                .load(url)
                .centerInside()
//        .diskCacheStrategy(DiskCacheStrategy.NONE)
//        .skipMemoryCache(true)
                .placeholder(R.drawable.ic_nytimes_ar21)
                .into(binding!!.articlePhotoImageview)
        })
    }


    override
    fun getViewModel() = articleViewModel
}