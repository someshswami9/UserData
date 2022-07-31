package com.someshswami.userdatataskapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository(private val userDataService: UserDataService) {

    private val usersLiveData = MutableLiveData<UserData>()

    val users : LiveData<UserData>
    get() = usersLiveData


    suspend fun getUsers(){
        val result = userDataService.getResult()

        if (result.body() != null)
        {
            usersLiveData.postValue(result.body())
        }
    }

}