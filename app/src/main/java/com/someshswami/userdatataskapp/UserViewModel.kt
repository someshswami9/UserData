package com.someshswami.userdatataskapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {


   init {
       viewModelScope.launch(IO) {
           userRepository.getUsers()
       }
   }


    val users : LiveData<UserData>
    get() = userRepository.users



}