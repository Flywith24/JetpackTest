package com.yyz.demo_room

import android.content.Context
import com.yyz.demo_room.data.UserRepository
import com.yyz.demo_room.viewmodel.UserViewModel

/**
 * @author yyz (杨云召)
 * @date   2019-12-29
 * time   23:02
 * description
 */
object InjectorUtils {
    private fun getUserRepository(context: Context): UserRepository =
        UserRepository.getInstance(AppDatabase.getInstance(context).userDao())

    fun provideUserViewModelFactory(context: Context): UserViewModel.UserViewModelFactory =
        UserViewModel.UserViewModelFactory(getUserRepository(context))

}