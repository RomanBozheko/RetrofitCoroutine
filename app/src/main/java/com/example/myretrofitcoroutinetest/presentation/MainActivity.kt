package com.example.myretrofitcoroutinetest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.myretrofitcoroutinetest.databinding.ActivityMainBinding

import com.example.myretrofitcoroutinetest.domain.UserApi
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "TAG_MainActivity-> "
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(this)).get(MyViewModel::class.java)


        lifecycleScope.launch {
            viewModel.nameUser
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect{binding.txtRes.text = it}

        }
        viewModel.showName()



//showRes()
    }

    private fun showRes() {

        val host = "https://jsonplaceholder.typicode.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(UserApi::class.java)

        val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

        coroutineScope.launch {
            val response = service.getUser(1)
            val user = response.body()
            if (user != null) {
                withContext(Dispatchers.Main) {
                binding.txtRes.text = user.name.toString()
                }
            } else {
                println("<<<<< ERROR >>>>>")
            }

            val responseAll = service.getAllUsers()
            val allUsers = responseAll.body()
            if(allUsers != null){
                for (i in allUsers.indices){
                    println("${allUsers[i].id} < > " +
                            "${allUsers[i].name} < > " +
                            "${allUsers[i].address!!.city} < > " +
                            "${allUsers[i].address!!.street}\n lat-> " +
                            "${allUsers[i].address!!.geo!!.lat}\n lng-> " +
                            "${allUsers[i].address!!.geo!!.lng}")
                }
            }else{
                println("<<<<< ERROR >>>>>")
            }


        }
    }
}



