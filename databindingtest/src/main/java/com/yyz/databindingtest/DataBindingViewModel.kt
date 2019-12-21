package com.yyz.databindingtest

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

/**
 * @author yyz (杨云召)
 * @date   2019/12/19
 * time   9:39
 * description
 */
class DataBindingViewModel : ViewModel() {
    var favoriteNum = ObservableInt()

    fun addFavoriteNum(n: Int) {
        val value = favoriteNum.get()
        if (value.plus(n) >= 0) {
            this.favoriteNum.set(value.plus(n))
        }
    }
}