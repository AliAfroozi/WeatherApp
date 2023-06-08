package com.example.weatherapp.feature_show_weather.data.repository

import com.example.weatherapp.feature_show_weather.data.data_source.WeatherApi
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocationWeather
import com.example.weatherapp.feature_show_weather.domain.repository.WeatherRepository
import com.example.weatherapp.feature_show_weather.presentation.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi) :
    WeatherRepository {
    override suspend fun getPointWeather(selectedLocation: SelectedLocation): Response<SelectedLocationWeather> {
        val q = selectedLocation.lat.toString() + "," + selectedLocation.long.toString()
        return weatherApi.getCurrentLocationWeather(
            key = MainActivity.API_KEY,
            queryParam = q)

    }
}