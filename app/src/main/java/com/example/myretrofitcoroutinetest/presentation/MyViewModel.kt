package com.example.myretrofitcoroutinetest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitcoroutinetest.domain.Result
import com.example.myretrofitcoroutinetest.domain.model.User

import com.example.myretrofitcoroutinetest.domain.repository.UserDomainRepository

import com.example.myretrofitcoroutinetest.presentation.user.mappers.UserPresentationMapper
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MyViewModel() : ViewModel() {


    companion object {
        const val TAG = "TAG_MyViewModel-> "
    }

    init {
        Log.d(TAG, "MyViewModel_created")

    }

    private var _nameUserMutable = MutableSharedFlow<String>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    var nameUser: SharedFlow<String> = _nameUserMutable.asSharedFlow()
    ////        _nameUserMutable.tryEmit(helper.showUserName(id))


    fun showUserName() {
        val userDomainRepository: UserDomainRepository? = null
        viewModelScope.launch {

            val user: User = userDomainRepository!!.getUserName()

            println(">>>>>>${user.name}<<<<<<<")
            test()

        }
    }

    private fun test(){
        val user:User? = null
        val resName = user?.name
        _nameUserMutable.tryEmit(resName.toString())
    }


}