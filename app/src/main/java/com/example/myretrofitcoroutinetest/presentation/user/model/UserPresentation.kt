package com.example.myretrofitcoroutinetest.presentation.user.model

import com.example.myretrofitcoroutinetest.data.api.model.AddressNetworkModel
import com.example.myretrofitcoroutinetest.data.api.model.ComapanyNetworkModel

data class UserPresentation(
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?,
    val addressNetworkModel: AddressNetworkModel?,
    val phone: String?,
    val website: String?,
    val company: ComapanyNetworkModel?
)
