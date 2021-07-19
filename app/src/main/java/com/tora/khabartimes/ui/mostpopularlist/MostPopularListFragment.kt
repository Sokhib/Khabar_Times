package com.tora.khabartimes.ui.mostpopularlist

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.tora.khabartimes.R
import com.tora.khabartimes.base.BaseFragment
import com.tora.khabartimes.databinding.MostPopularListFragmentBinding
import com.tora.khabartimes.utils.Period
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostPopularListFragment :
    BaseFragment<MostPopularListViewModel, MostPopularListFragmentBinding>(R.layout.most_popular_list_fragment) {

    private val mostPopularViewModel: MostPopularListViewModel by viewModels()
    private val articlesAdapter by lazy { ArticlesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.toolbar_title)
        setUpRecycler()
        observePopularArticles()
        onArticleClick()
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

    private fun onArticleClick() {
        articlesAdapter.onArticleClick = {
            val direction =
                MostPopularListFragmentDirections.actionMostPopularListFragmentToArticleDetailFragment(
                    it
                )
            navigateWithDirection(direction)
        }
    }

    private fun setUpRecycler() {
        binding!!.articlesRecycler.apply {
            adapter = articlesAdapter
            setHasFixedSize(true)
        }
    }

    private fun observePopularArticles() {
        mostPopularViewModel.popularArticles.observe(viewLifecycleOwner, {
            articlesAdapter.setArticleList(it.results!!)
            binding!!.executePendingBindings()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.period_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_today -> {
                mostPopularViewModel.getPopularArticles(Period.ONE)
                return true
            }
            R.id.item_last_week -> {
                mostPopularViewModel.getPopularArticles(Period.SEVEN)
                return true
            }
            R.id.item_last_month -> {
                mostPopularViewModel.getPopularArticles(Period.THIRTY)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getViewModel() = mostPopularViewModel

}