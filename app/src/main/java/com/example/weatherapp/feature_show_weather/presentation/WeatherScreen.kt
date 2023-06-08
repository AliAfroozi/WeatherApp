package com.example.weatherapp.feature_show_weather.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WeatherScreen(lat: Double?, long: Double?, navController: NavHostController, weatherViewModel: WeatherViewModel = hiltViewModel()) {


    var weather = remember {
        mutableStateOf(weatherViewModel.weather)
    }


    Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center) {
        if (weather.value.value.isNotEmpty())
            Text(text = weather.value.value[0].current.condition.text)
        else {
            if (long != null && lat != null && weather.value.value.isEmpty()) {
                LaunchedEffect(Unit){
                    CoroutineScope(Dispatchers.IO).launch {
                        weatherViewModel.showPointWeather(SelectedLocation(lat , long))
                    }
                }
            }
        }
    }
}