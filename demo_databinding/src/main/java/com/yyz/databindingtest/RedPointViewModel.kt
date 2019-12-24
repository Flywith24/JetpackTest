package com.yyz.databindingtest

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

/**
 * @author yyz (杨云召)
 * @date   2019/12/20
 * time   9:05
 * description
 */
class RedPointViewModel : ViewModel() {
    val redPoint = ObservableBoolean()
}