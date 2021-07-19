package com.tora.khabartimes.ui.articledetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.tora.khabartimes.base.BaseViewModel
import com.tora.khabartimes.data.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _article = MutableLiveData<Result>()
    val article: LiveData<Result>
        get() = _article


    init {
        Timber.d("${savedStateHandle.contains("article")}")
        Timber.d("${savedStateHandle.get<Result>("article")}")
        _article.value = savedStateHandle.get<Result>("article")
    }

}