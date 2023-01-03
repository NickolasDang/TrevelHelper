package com.example.search_flights_feature.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.search_flights_feature.R

class SearchFlightsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_flights)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFlightsFragment.newInstance())
                .commitNow()
        }
    }
}