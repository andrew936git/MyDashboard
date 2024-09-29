package com.example.mydashboard

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val users: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User){
        userDao.insert(user)
    }


}