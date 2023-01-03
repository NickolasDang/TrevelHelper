package com.example.search_flights_feature.data.network.api

import com.example.search_flights_feature.data.network.models.AccessTokenResponse
import com.example.search_flights_feature.data.network.models.SearchFlightsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlightRemoteDataSource(
    private val flightsApi: FlightsApi
) : IFlightRemoteDataSource {

    companion object {
        private const val GRANT_TYPE = "client_credentials"
        private const val CLIENT_ID = "AdyLJDzXRmy7AjmebcaBWLjYYz8SqU9v"
        private const val CLIENT_SECRET = "TLbUjoafeAhXwD4P"
    }

    override suspend fun getFlightOffers(accessToken: String): Flow<SearchFlightsResponse> =
        flow {
            emit(flightsApi.getFlightOffers(
                mapOf(
                    "originLocationCode" to "SYD",
                    "destinationLocationCode" to "BKK",
                    "departureDate" to "2023-05-02",
                    "adults" to "1",
                    "max" to "1"
                ), accessToken
            ))
        }


    override suspend fun getAccessToken(): Flow<AccessTokenResponse> =
        flow {
            emit(flightsApi.getAccessToken(mapOf(
                "grant_type" to GRANT_TYPE,
                "client_id" to CLIENT_ID,
                "client_secret" to CLIENT_SECRET
            )))
        }
}