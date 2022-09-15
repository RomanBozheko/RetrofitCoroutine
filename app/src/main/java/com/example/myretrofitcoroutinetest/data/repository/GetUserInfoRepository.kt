package com.example.myretrofitcoroutinetest.data.repository

import com.example.myretrofitcoroutinetest.data.api.UserApi
import com.example.myretrofitcoroutinetest.data.mappers.UserMapper
import com.example.myretrofitcoroutinetest.domain.Result
import com.example.myretrofitcoroutinetest.domain.model.User
import com.example.myretrofitcoroutinetest.domain.repository.UserDomainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GetUserInfoRepository(
    private val userMapper: UserMapper,
    private val userApi: UserApi
) : UserDomainRepository {
    override suspend fun getUserName() = withContext(Dispatchers.IO) {
        Result {
            userApi.getUser(1).name
        }

    }

}