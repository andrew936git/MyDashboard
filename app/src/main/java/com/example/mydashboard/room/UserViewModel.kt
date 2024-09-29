package com.example.mydashboard.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UserRepository
    val users: LiveData<List<User>>

    init {
        val dao = UserDatabase.getBase(application).getUserDao()
        repository = UserRepository(dao)
        users = repository.users
    }

   // val userList: List<User> = repository.userList

    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(user)
    }


}