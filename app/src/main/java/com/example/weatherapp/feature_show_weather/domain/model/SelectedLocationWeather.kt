package com.example.weatherapp.feature_show_weather.domain.model

data class SelectedLocationWeather(
    val temp_c: Double,
    val temp_f: Double,
    val last_updated: String,
    val is_day: Boolean,
    val text: String,
    var icon: String
)