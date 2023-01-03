package com.example.search_flights_feature.data.network.repositories

import com.example.search_flights_feature.data.network.api.IFlightRemoteDataSource

class FlightsRepository(
    private val remoteDataSource: IFlightRemoteDataSource
) {

    suspend fun getFlightOffers(accessToken: String) =
        remoteDataSource.getFlightOffers(accessToken)

    suspend fun getAccessToken() = remoteDataSource.getAccessToken()
}