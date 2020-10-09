package com.martiandeveloper.tictactoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _eventContinueMBTNClick = MutableLiveData<Boolean>()
    val eventContinueMBTNClick: LiveData<Boolean>
        get() = _eventContinueMBTNClick

    private var _eventHomeMBTNClick = MutableLiveData<Boolean>()
    val eventHomeMBTNClick: LiveData<Boolean>
        get() = _eventHomeMBTNClick

    private var _gameOverText = MutableLiveData<String>()
    val gameOverText: LiveData<String>
        get() = _gameOverText

    private var _eventFirstMBTNClick = MutableLiveData<Boolean>()
    val eventFirstMBTNClick: LiveData<Boolean>
        get() = _eventFirstMBTNClick

    private var _eventSecondMBTNClick = MutableLiveData<Boolean>()
    val eventSecondMBTNClick: LiveData<Boolean>
        get() = _eventSecondMBTNClick

    private var _eventThirdMBTNClick = MutableLiveData<Boolean>()
    val eventThirdMBTNClick: LiveData<Boolean>
        get() = _eventThirdMBTNClick

    private var _eventFourthMBTNClick = MutableLiveData<Boolean>()
    val eventFourthMBTNClick: LiveData<Boolean>
        get() = _eventFourthMBTNClick

    private var _eventFifthMBTNClick = MutableLiveData<Boolean>()
    val eventFifthMBTNClick: LiveData<Boolean>
        get() = _eventFifthMBTNClick

    private var _eventSixthMBTNClick = MutableLiveData<Boolean>()
    val eventSixthMBTNClick: LiveData<Boolean>
        get() = _eventSixthMBTNClick

    private var _eventSeventhMBTNClick = MutableLiveData<Boolean>()
    val eventSeventhMBTNClick: LiveData<Boolean>
        get() = _eventSeventhMBTNClick

    private var _eventEighthMBTNClick = MutableLiveData<Boolean>()
    val eventEighthMBTNClick: LiveData<Boolean>
        get() = _eventEighthMBTNClick

    private var _eventNinthMBTNClick = MutableLiveData<Boolean>()
    val eventNinthMBTNClick: LiveData<Boolean>
        get() = _eventNinthMBTNClick

    private var _eventTryAgainMBTNClick = MutableLiveData<Boolean>()
    val eventTryAgainMBTNClick: LiveData<Boolean>
        get() = _eventTryAgainMBTNClick

    private var _eventHome2MBTNClick = MutableLiveData<Boolean>()
    val eventHome2MBTNClick: LiveData<Boolean>
        get() = _eventHome2MBTNClick

    private var _isFirstMCVActive = MutableLiveData<Boolean>()
    val isFirstMCVActive: LiveData<Boolean>
        get() = _isFirstMCVActive

    private var _isSecondMCVActive = MutableLiveData<Boolean>()
    val isSecondMCVActive: LiveData<Boolean>
        get() = _isSecondMCVActive

    private var _isThirdMCVActive = MutableLiveData<Boolean>()
    val isThirdMCVActive: LiveData<Boolean>
        get() = _isThirdMCVActive

    private var _isFourthMCVActive = MutableLiveData<Boolean>()
    val isFourthMCVActive: LiveData<Boolean>
        get() = _isFourthMCVActive

    private var _isFifthMCVActive = MutableLiveData<Boolean>()
    val isFifthMCVActive: LiveData<Boolean>
        get() = _isFifthMCVActive

    private var _isSixthMCVActive = MutableLiveData<Boolean>()
    val isSixthMCVActive: LiveData<Boolean>
        get() = _isSixthMCVActive

    private var _isSeventhMCVActive = MutableLiveData<Boolean>()
    val isSeventhMCVActive: LiveData<Boolean>
        get() = _isSeventhMCVActive

    private var _isEighthMCVActive = MutableLiveData<Boolean>()
    val isEighthMCVActive: LiveData<Boolean>
        get() = _isEighthMCVActive

    private var _isNinthMCVActive = MutableLiveData<Boolean>()
    val isNinthMCVActive: LiveData<Boolean>
        get() = _isNinthMCVActive


    fun onContinueMBTNClick() {
        _eventContinueMBTNClick.value = true
    }

    fun onContinueMBTNClickComplete() {
        _eventContinueMBTNClick.value = false
    }

    fun onHomeMBTNClick() {
        _eventHomeMBTNClick.value = true
    }

    fun onHomeMBTNClickComplete() {
        _eventHomeMBTNClick.value = false
    }

    fun setGameOverText(text: String) {
        _gameOverText.value = text
    }

    fun onFirstMBTNClick() {
        _eventFirstMBTNClick.value = true
    }

    fun onFirstMBTNClickComplete() {
        _eventFirstMBTNClick.value = false
    }

    fun onSecondMBTNClick() {
        _eventSecondMBTNClick.value = true
    }

    fun onSecondMBTNClickComplete() {
        _eventSecondMBTNClick.value = false
    }

    fun onThirdMBTNClick() {
        _eventThirdMBTNClick.value = true
    }

    fun onThirdMBTNClickComplete() {
        _eventThirdMBTNClick.value = false
    }

    fun onFourthMBTNClick() {
        _eventFourthMBTNClick.value = true
    }

    fun onFourthMBTNClickComplete() {
        _eventFourthMBTNClick.value = false
    }

    fun onFifthMBTNClick() {
        _eventFifthMBTNClick.value = true
    }

    fun onFifthMBTNClickComplete() {
        _eventFifthMBTNClick.value = false
    }

    fun onSixthMBTNClick() {
        _eventSixthMBTNClick.value = true
    }

    fun onSixthMBTNClickComplete() {
        _eventSixthMBTNClick.value = false
    }

    fun onSeventhMBTNClick() {
        _eventSeventhMBTNClick.value = true
    }

    fun onSeventhMBTNClickComplete() {
        _eventSeventhMBTNClick.value = false
    }

    fun onEighthMBTNClick() {
        _eventEighthMBTNClick.value = true
    }

    fun onEighthMBTNClickComplete() {
        _eventEighthMBTNClick.value = false
    }

    fun onNinthMBTNClick() {
        _eventNinthMBTNClick.value = true
    }

    fun onNinthMBTNClickComplete() {
        _eventNinthMBTNClick.value = false
    }

    fun onTryAgainMBTNClick() {
        _eventTryAgainMBTNClick.value = true
    }

    fun onTryAgainMBTNClickComplete() {
        _eventTryAgainMBTNClick.value = false
    }

    fun onHome2MBTNClick() {
        _eventHome2MBTNClick.value = true
    }

    fun onHome2MBTNClickComplete() {
        _eventHome2MBTNClick.value = false
    }

    fun setFirstMCVActive(active: Boolean) {
        _isFirstMCVActive.value = active
    }

    fun setSecondMCVActive(active: Boolean) {
        _isSecondMCVActive.value = active
    }

    fun setThirdMCVActive(active: Boolean) {
        _isThirdMCVActive.value = active
    }

    fun setFourthMCVActive(active: Boolean) {
        _isFourthMCVActive.value = active
    }

    fun setFifthMCVActive(active: Boolean) {
        _isFifthMCVActive.value = active
    }

    fun setSixthMCVActive(active: Boolean) {
        _isSixthMCVActive.value = active
    }

    fun setSeventhMCVActive(active: Boolean) {
        _isSeventhMCVActive.value = active
    }

    fun setEighthMCVActive(active: Boolean) {
        _isEighthMCVActive.value = active
    }

    fun setNinthMCVActive(active: Boolean) {
        _isNinthMCVActive.value = active
    }

}
