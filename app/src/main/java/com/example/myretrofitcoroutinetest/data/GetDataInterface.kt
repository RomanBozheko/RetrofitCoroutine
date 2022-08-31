package com.example.myretrofitcoroutinetest.data

import com.example.myretrofitcoroutinetest.domain.UserApi
import kotlinx.coroutines.Job

interface GetDataInterface {
    fun getRetrofitInstance(host:String): UserApi
    fun getUserName(id: Int):String
}