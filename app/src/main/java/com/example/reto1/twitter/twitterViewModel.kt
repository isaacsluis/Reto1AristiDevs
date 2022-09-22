package com.example.reto1.twitter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwitterViewModel : ViewModel() {

    private val _likeNum = MutableLiveData<Int>()
    val likeNum: LiveData<Int> = _likeNum

    private val _rtNum = MutableLiveData<Int>()
    val rtNum: LiveData<Int> = _rtNum

    private val _chatNum = MutableLiveData<Int>()
    val chatNum: LiveData<Int> = _chatNum

    private val _like = MutableLiveData<Boolean>()
    val like: LiveData<Boolean> = _like

    private val _rt = MutableLiveData<Boolean>()
    val rt: LiveData<Boolean> = _rt

    private val _chat = MutableLiveData<Boolean>()
    val chat: LiveData<Boolean> = _chat


    fun onClicLike(dato: Boolean, tipo: Int, num: Int) {

        when (tipo) {
            1 -> {
                _like.value = !dato
                if (dato) {
                    _likeNum.value = num + 1
                } else {
                    _likeNum.value = num - 1
                }
            }
            2 -> {
                _rt.value = !dato
                if (dato) {
                    _rtNum.value = num + 1
                } else {
                    _rtNum.value = num - 1
                }
            }
            3 -> {
                _chat.value = !dato
                if (dato) {
                    _chatNum.value = num + 1
                } else {
                    _chatNum.value = num - 1
                }
            }
        }
    }
}