package com.yyz.livedatatest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author yyz (杨云召)
 * @date   2019/12/19
 * time   9:39
 * description
 */
class LiveDataViewModel : ViewModel() {
    var favoriteNum: MutableLiveData<Int> = MutableLiveData()

    init {
        favoriteNum.value = 0
    }

    fun addFavoriteNum(n: Int) {
        val value = favoriteNum.value!!
        if (value.plus(n) >= 0) {
            this.favoriteNum.value = value.plus(n)
        }
    }
}