package com.example.myretrofitcoroutinetest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myretrofitcoroutinetest.domain.Helper
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class MyViewModel : ViewModel() {
    val helper = Helper()

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


    fun showName(id: Int) {
        _nameUserMutable.tryEmit(helper.showUserName(id))
    }


}