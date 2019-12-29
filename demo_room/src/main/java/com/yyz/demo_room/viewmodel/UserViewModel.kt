package com.yyz.demo_room.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yyz.demo_room.data.User
import com.yyz.demo_room.data.UserRepository

/**
 * @author yyz (杨云召)
 * @date   2019-12-29
 * time   22:36
 * description
 */
class UserViewModel internal constructor(
    private val repository: UserRepository
) : ViewModel() {

    val users: LiveData<List<User>> = repository.getUsers()
    fun insert(user: User) = repository.insert(user)
    fun delete(user: User) = repository.delete(user)

    class UserViewModelFactory(
        private val repository: UserRepository
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(repository) as T
        }
    }
}

