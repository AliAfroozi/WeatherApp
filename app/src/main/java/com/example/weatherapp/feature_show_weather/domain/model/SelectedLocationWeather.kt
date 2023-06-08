package com.example.weatherapp.feature_show_weather.domain.model

data class SelectedLocationWeather(
    val location: Location,
    val current: Current
)