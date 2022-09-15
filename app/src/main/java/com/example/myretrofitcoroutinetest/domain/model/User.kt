package com.example.myretrofitcoroutinetest.domain.model

import com.example.myretrofitcoroutinetest.data.api.model.AddressNetworkModel
import com.example.myretrofitcoroutinetest.data.api.model.ComapanyNetworkModel
import com.example.myretrofitcoroutinetest.domain.Result
import java.util.*

class User private constructor(
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?,
    val addressNetworkModel: AddressNetworkModel?,
    val phone: String?,
    val website: String?,
    val company: ComapanyNetworkModel?
) {
    companion object {
        fun of(
            id: Int?,
            name: String?,
            username: String?,
            email: String?,
            addressNetworkModel: AddressNetworkModel?,
            phone: String?,
            website: String?,
            company: ComapanyNetworkModel?
        ): Result<User> {

            return Result {

                User(
                    id = id,
                    name = name,
                    username = username,
                    email = email,
                    addressNetworkModel = addressNetworkModel,
                    phone = phone,
                    website = website,
                    company = company
                )
            }
        }
    }
}