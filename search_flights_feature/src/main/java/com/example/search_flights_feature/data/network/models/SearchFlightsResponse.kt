package com.example.search_flights_feature.data.network.models

import com.squareup.moshi.Json

data class SearchFlightsResponse(
    @Json(name = "data")
    val flightOffers: List<FlightOfferResponse>,
)