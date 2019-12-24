package com.yyz.livedatatest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author yyz (杨云召)
 * @date   2019/12/20
 * time   9:05
 * description
 */
class RedPointViewModel : ViewModel() {
    val redPoint = MutableLiveData<Boolean>()

    init {
        redPoint.value = false
    }
}