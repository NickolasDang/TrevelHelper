package com.example.search_flights_feature.data.network

import com.example.search_flights_feature.data.network.api.FlightRemoteDataSource
import com.example.search_flights_feature.data.network.api.FlightsApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {

    private const val BASE_URL = "https://test.api.amadeus.com/"

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val flightsApi: FlightsApi by lazy {
        retrofit.create(FlightsApi::class.java)
    }

    val flightRemoteDataSource = FlightRemoteDataSource(flightsApi)
}