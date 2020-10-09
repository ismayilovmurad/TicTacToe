package com.martiandeveloper.tictactoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var _eventStartMBTNClick = MutableLiveData<Boolean>()
    val eventStartMBTNClick: LiveData<Boolean>
        get() = _eventStartMBTNClick


    fun onStartMBTNClick() {
        _eventStartMBTNClick.value = true
    }

    fun onStartMBTNClickComplete() {
        _eventStartMBTNClick.value = false
    }

}
