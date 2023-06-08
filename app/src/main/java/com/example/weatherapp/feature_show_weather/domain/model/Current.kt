package com.example.weatherapp.feature_show_weather.domain.model

data class Current(
    val temp_c: String,
    val temp_f: String,
    val is_day: Int,
    val condition: Condition
)
