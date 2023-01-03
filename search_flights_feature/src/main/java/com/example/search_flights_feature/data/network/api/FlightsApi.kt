package com.example.search_flights_feature.data.network.api

import com.example.search_flights_feature.data.network.models.AccessTokenResponse
import com.example.search_flights_feature.data.network.models.SearchFlightsResponse
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface FlightsApi {

    @GET("v2/shopping/flight-offers")
    suspend fun getFlightOffers(
        @QueryMap fieldMap: Map<String, String>,
        @Header("Authorization") auth: String
    ) : SearchFlightsResponse

    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    @POST("v1/security/oauth2/token")
    suspend fun getAccessToken(@FieldMap fieldMap: Map<String, String>) : AccessTokenResponse
}