package com.example.myretrofitcoroutinetest.presentation.user.mappers

import com.example.myretrofitcoroutinetest.domain.model.User
import com.example.myretrofitcoroutinetest.presentation.user.model.UserPresentation

class UserPresentationMapper() {
    fun toUi(user: User):UserPresentation{
        return UserPresentation(
            id = user.id,
            name = user.name,
            username = user.username,
            email = user.email,
            addressNetworkModel = user.addressNetworkModel,
            phone = user.phone,
            website = user.website,
            company = user.company

        )
    }
}