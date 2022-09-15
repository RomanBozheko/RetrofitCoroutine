package com.example.myretrofitcoroutinetest.data.api

import com.example.myretrofitcoroutinetest.data.api.ApiConstants.BASE_ENDPOINT
import com.example.myretrofitcoroutinetest.data.api.model.UserNetworkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("$BASE_ENDPOINT/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): UserNetworkModel
}