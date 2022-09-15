package com.example.myretrofitcoroutinetest.data.mappers

import com.example.myretrofitcoroutinetest.data.api.model.UserNetworkModel
import com.example.myretrofitcoroutinetest.domain.Result
import com.example.myretrofitcoroutinetest.domain.model.User

class UserMapper {
    fun toDomain(userNetworkModel: UserNetworkModel): Result<User> {
        val (
            id,
            name,
            username,
            email,
            addressNetworkModel,
            phone,
            website,
            company
        ) = userNetworkModel

        return User.of(id, name, username, email, addressNetworkModel, phone, website, company)

    }
}