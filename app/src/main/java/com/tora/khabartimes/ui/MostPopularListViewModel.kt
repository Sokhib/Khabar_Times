package com.tora.khabartimes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tora.khabartimes.base.BaseViewModel
import com.tora.khabartimes.data.model.PopularArticles
import com.tora.khabartimes.data.network.NYTNetworkDataSourceImpl
import com.tora.khabartimes.utils.Period
import com.tora.khabartimes.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MostPopularListViewModel @Inject constructor(private val networkDataSourceImpl: NYTNetworkDataSourceImpl) :
    BaseViewModel() {

    private val _popularArticles = MutableLiveData<PopularArticles>()
    val popularArticles: LiveData<PopularArticles>
        get() = _popularArticles

    init {
        getPopularArticles()
    }

    fun getPopularArticles(period: Period = Period.SEVEN) {
        viewModelScope.launch {
            increaseProgress()
            networkDataSourceImpl.getMostPopularArticles(period)
                .collect { popularArticlesState ->
                    when (popularArticlesState.status) {
                        Status.SUCCESS -> {
                            decreaseProgress()
                            _popularArticles.value = popularArticlesState.data!!
                        }
                        Status.ERROR -> {
                            decreaseProgress()
                            showMessage(popularArticlesState.message)
                        }

                    }
                }
        }
    }
}