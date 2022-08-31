package com.example.myretrofitcoroutinetest.data

import com.example.myretrofitcoroutinetest.data.json_model.User
import com.example.myretrofitcoroutinetest.domain.UserApi
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetData : GetDataInterface {
    private val host = "https://jsonplaceholder.typicode.com/"

    override fun getRetrofitInstance(host: String): UserApi {


        val retrofit = Retrofit.Builder()
            .baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(UserApi::class.java)
    }


    override fun getUserName(id: Int): String {

        val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        var res = " > 0 | 0 < "

        coroutineScope.launch {

            val response = getRetrofitInstance(host).getUser(id)
            println(" >>> $response <<< ")
            val userName = response.body()!!.name
            res = userName!!.toString()
            withContext(Dispatchers.Main){

                res = userName.toString()
                println(" >>> $res <<< ")

            }
            println("res > $res")
        }
        return res

    }
}