package com.example.myretrofitcoroutinetest.domain.repository

import com.example.myretrofitcoroutinetest.domain.Result
import com.example.myretrofitcoroutinetest.domain.model.User

interface UserDomainRepository {
    suspend fun getUserName(): User
}