package com.example.search_flights_feature.data.network.models

import com.squareup.moshi.Json

data class ItinerariesResponse(
    @Json(name = "segments")
    val flights: List<FlightResponse>
)

data class FlightResponse(
    @Json(name = "departure")
    val departure: DepartureArrivalResponse,
    @Json(name = "arrival")
    val arrival: DepartureArrivalResponse
)

data class DepartureArrivalResponse(
    @Json(name = "iataCode")
    val iataCode: String,
    @Json(name = "at")
    val time: String
)