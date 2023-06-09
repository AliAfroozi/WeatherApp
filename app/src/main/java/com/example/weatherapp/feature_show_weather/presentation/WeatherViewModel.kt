package com.example.weatherapp.feature_show_weather.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.feature_show_weather.data.data_source.WeatherApi
import com.example.weatherapp.feature_show_weather.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocationWeather
import com.example.weatherapp.feature_show_weather.domain.use_case.LocationWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherUseCase: LocationWeatherUseCase) :
    ViewModel() {

     var weather = listOf<SelectedLocationWeather>()


     fun showPointWeather(
        selectedLocation: SelectedLocation,
        onResponse: (Response<SelectedLocationWeather>) -> Unit
    ) {
        viewModelScope.launch {
            onResponse(weatherUseCase.getLocationWeather(selectedLocation))
        }
    }

}




