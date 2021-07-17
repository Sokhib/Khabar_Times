package com.tora.khabartimes.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tora.khabartimes.helper.Event

abstract class BaseViewModel : ViewModel() {
    private val _progressState = MutableLiveData(0)
    val progressState: LiveData<Int>
        get() = _progressState


    private val _errorText = MutableLiveData<Event<String>>()
    val errorText: LiveData<Event<String>>
        get() = _errorText

    fun showMessage(text: String?) {
        text?.let {
            _errorText.value = Event(text)
        }
    }

    fun increaseProgress() {
        _progressState.value = _progressState.value?.plus(1)
    }

    fun decreaseProgress() {
        _progressState.value = _progressState.value?.minus(1)
    }

}