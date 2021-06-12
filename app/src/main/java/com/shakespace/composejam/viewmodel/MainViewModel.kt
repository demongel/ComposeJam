package com.shakespace.composejam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val _keyword = MutableLiveData<String>()

    val keyword: LiveData<String>
        get() = _keyword

    private val keywords =
        mutableListOf<String>("iPhone 12", "Mate 40", "Air Pods", "Free Buds", "iPad", "MatePad")


    fun findKeyWord() {
        viewModelScope.launch {
            var index = Random.nextInt(0, keywords.size)
            if (keyword.value == keywords[index]) {
                index = if (index == keywords.size - 1) {
                    0
                } else {
                    index + 1
                }
            }
            _keyword.value = keywords[index]
            delay(2000)
            findKeyWord()
        }
    }
}