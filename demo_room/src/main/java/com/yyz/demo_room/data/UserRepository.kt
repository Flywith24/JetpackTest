package com.yyz.demo_room.data

import androidx.lifecycle.LiveData

/**
 * @author yyz (杨云召)
 * @date   2019-12-29
 * time   22:37
 * description
 */
class UserRepository private constructor(
    private val userDao: UserDao
) {

    fun getUsers(): LiveData<List<User>> = userDao.getAll()

    fun insert(user: User) = userDao.insertAll(user)

    fun delete(user: User) = userDao.delete(user)

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(gardenPlantingDao: UserDao) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(gardenPlantingDao).also { instance = it }
            }
    }
}