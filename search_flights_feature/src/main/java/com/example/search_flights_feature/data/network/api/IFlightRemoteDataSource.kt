package com.example.search_flights_feature.data.network.api

import com.example.search_flights_feature.data.network.models.AccessTokenResponse
import com.example.search_flights_feature.data.network.models.SearchFlightsResponse
import kotlinx.coroutines.flow.Flow

interface IFlightRemoteDataSource {

    suspend fun getFlightOffers(accessToken: String): Flow<SearchFlightsResponse>
    suspend fun getAccessToken(): Flow<AccessTokenResponse>
}