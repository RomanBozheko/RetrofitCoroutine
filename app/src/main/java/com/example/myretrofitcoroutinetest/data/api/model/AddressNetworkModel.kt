package com.example.myretrofitcoroutinetest.data.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddressNetworkModel(
    var street: String? = null,
    var suite: String? = null,
    var city: String? = null,
    var zipcode: String? = null,
    var geo: GeoNetworkModel? = null
)
