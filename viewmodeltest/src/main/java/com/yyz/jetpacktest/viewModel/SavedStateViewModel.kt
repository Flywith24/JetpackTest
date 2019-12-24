package com.yyz.jetpacktest.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * @author yyz (杨云召)
 * @date   2019/12/24
 * time   11:15
 * description
 *
 * 进程被后台杀死 ViewModel也能保持之前数据
 */
class SavedStateViewModel(private val state: SavedStateHandle) : ViewModel() {
    var number: Int
        set(value) = state.set("KEY", value)
        get() = state.get<Int>("KEY") ?: 0
}