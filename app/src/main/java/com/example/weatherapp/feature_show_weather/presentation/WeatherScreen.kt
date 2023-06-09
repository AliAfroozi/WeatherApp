package com.example.weatherapp.feature_show_weather.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocationWeather
import kotlinx.coroutines.*

@Composable
fun WeatherScreen(
    lat: Double?,
    long: Double?,
    navHostController: NavHostController,
    weatherViewModel: WeatherViewModel = hiltViewModel()
) {


    val weather = remember {
        mutableStateOf(weatherViewModel.weather)
    }



    Log.e("ScreenShow ", "ScreenShow")




    if (weatherViewModel.weather.isEmpty()){

        LaunchedEffect(Unit) {
            Log.e("API ", "Called API")
            weatherViewModel.showPointWeather(SelectedLocation(lat!!, long!!)) {
                if (it.isSuccessful){
                    weatherViewModel.weather = listOf(it.body()!!)
                }
            }

        }
    }



    if (weatherViewModel.weather.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (weatherViewModel.weather.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = weatherViewModel.weather[0].current.condition.text)
        }
    }
}

