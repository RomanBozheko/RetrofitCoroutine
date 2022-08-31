package com.example.myretrofitcoroutinetest.domain

import com.example.myretrofitcoroutinetest.data.GetData

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Helper: HelperInterface {

    var getData = GetData()



    override fun showUserName(id: Int): String {
        return  getData.getUserName(id)
    }
}