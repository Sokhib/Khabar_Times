package com.tora.khabartimes.ui

import androidx.lifecycle.viewModelScope
import com.tora.khabartimes.base.BaseViewModel
import com.tora.khabartimes.data.network.NYTNetworkDataSourceImpl
import com.tora.khabartimes.utils.Period
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MostPopularListViewModel @Inject constructor(private val networkDataSourceImpl: NYTNetworkDataSourceImpl) :
    BaseViewModel() {
    init {
        viewModelScope.launch {
            networkDataSourceImpl.getMostPopularArticles(Period.SEVEN)
                .collect {
                    Timber.d("${it.status}")
                }
        }
    }
}