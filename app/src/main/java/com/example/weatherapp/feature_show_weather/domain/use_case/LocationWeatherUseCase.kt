package com.example.weatherapp.feature_show_weather.domain.use_case

import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocationWeather
import com.example.weatherapp.feature_show_weather.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class LocationWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {
    suspend fun getLocationWeather(selectedLocation: SelectedLocation): Response<SelectedLocationWeather> {
        return weatherRepository.getPointWeather(selectedLocation)
    }
}