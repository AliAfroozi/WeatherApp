package com.example.weatherapp.feature_show_weather.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocationWeather
import com.example.weatherapp.feature_show_weather.domain.use_case.LocationWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherUseCase: LocationWeatherUseCase) :
    ViewModel() {

    var weather = mutableStateOf(listOf<SelectedLocationWeather>())

    init {
    }

    suspend fun showPointWeather(
        selectedLocation: SelectedLocation,
    ) {
        if (weather.value.isNotEmpty())
            weather.value = listOf(weatherUseCase.getLocationWeather(selectedLocation).body()!!)
    }

}