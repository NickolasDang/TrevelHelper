package com.example.search_flights_feature.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.search_flights_feature.data.network.NetworkLayer
import com.example.search_flights_feature.data.network.repositories.FlightsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFlightsViewModel : ViewModel() {

    private val repository = FlightsRepository(NetworkLayer.flightRemoteDataSource)

    init {
        getFlightOffers()
    }

    fun getFlightOffers() {
        viewModelScope.launch {
            val accessToken = getAccessToken()
            repository.getFlightOffers(accessToken)
                .flowOn(Dispatchers.IO)
                .catch { exception ->
                    Log.d("getFlightOffers", "Exception-> ${exception.message}")
                }
                .collect {
                    val result = it.flightOffers
                    Log.d("getFlightOffers", "Response-> ${result.first().price}")
                }
        }
    }

    private suspend fun getAccessToken(): String {
        return withContext(viewModelScope.coroutineContext) {
            var accessToken = ""
            repository.getAccessToken()
                .flowOn(Dispatchers.IO)
                .catch { exception ->
                    Log.d("getAccessToken", "Exception-> ${exception.cause}")
                }
                .collect {
                    Log.d("getAccessToken", "Response-> ${it.token}")
                    accessToken = "${it.tokenType} ${it.token}"
                }
            accessToken
        }
    }
}