package com.example.weatherapp.feature_show_weather.domain.model

data class Location(
    private val name : String,
    private val region : String,
    private val country : String,
    private val lat : Double,
    private val lon : Double,
    private val tz_id : String,
    private val localtime_epoch : String,
    private val localtime : String
)
