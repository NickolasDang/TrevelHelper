package com.example.search_flights_feature.data.network.models

import com.squareup.moshi.Json

data class AccessTokenResponse(
    @Json(name = "token_type")
    val tokenType: String,
    @Json(name = "access_token")
    val token: String
)