package com.example.myretrofitcoroutinetest.domain

import com.example.myretrofitcoroutinetest.data.json_model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("users/{userId}")
   suspend fun getUser(@Path("userId") userId: Int):Response<User>

    @GET("users")
    suspend fun getAllUsers():Response<List<User>>
}