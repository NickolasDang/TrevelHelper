package com.example.search_flights_feature.data.network.models

import com.squareup.moshi.Json

data class PriceResponse(
    @Json(name = "currency")
    val currency: String,
    @Json(name = "total")
    val amount: Double
)