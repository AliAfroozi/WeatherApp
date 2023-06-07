package com.example.weatherapp.feature_show_weather.domain.repository

import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation

interface WeatherRepository {
    fun getCityWeather(selectedLocation: SelectedLocation)
}