package com.tora.khabartimes.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.tora.khabartimes.R
import com.tora.khabartimes.base.BaseFragment
import com.tora.khabartimes.databinding.MostPopularListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostPopularListFragment :
    BaseFragment<MostPopularListViewModel, MostPopularListFragmentBinding>(R.layout.most_popular_list_fragment) {

    private val mostPopularViewModel: MostPopularListViewModel by viewModels()

    override fun getViewModel() = mostPopularViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}