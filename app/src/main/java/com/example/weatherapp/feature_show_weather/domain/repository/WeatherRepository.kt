package com.example.weatherapp.feature_show_weather.domain.repository

import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocationWeather
import retrofit2.Response

interface WeatherRepository {
    suspend fun getPointWeather(selectedLocation: SelectedLocation) : Response<SelectedLocationWeather>
}