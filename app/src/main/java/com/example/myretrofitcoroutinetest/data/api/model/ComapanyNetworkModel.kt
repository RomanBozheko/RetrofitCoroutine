package com.example.myretrofitcoroutinetest.data.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ComapanyNetworkModel(
    var name: String? = null,
    var catchPhrase: String? = null,
    var bs: String? = null
)
