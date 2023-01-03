package com.example.search_flights_feature.data.network.models

import com.squareup.moshi.Json

data class FlightOfferResponse(
    @Json(name = "itineraries")
    val itineraries: List<ItinerariesResponse>,
    @Json(name = "price")
    val price: PriceResponse
)