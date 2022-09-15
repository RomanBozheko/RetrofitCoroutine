package com.example.myretrofitcoroutinetest.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofitcoroutinetest.domain.repository.UserDomainRepository
import com.example.myretrofitcoroutinetest.presentation.user.mappers.UserPresentationMapper

class MyViewModelFactory(context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel() as T
    }
}