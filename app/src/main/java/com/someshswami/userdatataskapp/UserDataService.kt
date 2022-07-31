package com.someshswami.userdatataskapp

import retrofit2.Response
import retrofit2.http.GET

interface UserDataService {

    @GET("/api/?results=50")
    suspend fun getResult() : Response<UserData>
}