package com.example.myretrofitcoroutinetest.data.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeoNetworkModel(
    var lat: String? = null,
    var lng: String? = null
)