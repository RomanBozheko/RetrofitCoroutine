package com.example.myretrofitcoroutinetest.data.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserNetworkModel(
    var id: Int? = null,
    var name: String? = null,
    var username: String? = null,
    var email: String? = null,
    var addressNetworkModel: AddressNetworkModel? = null,
    var phone: String? = null,
    var website: String? = null,
    var company: ComapanyNetworkModel? = null
)
