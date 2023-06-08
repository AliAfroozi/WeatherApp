package com.example.weatherapp.feature_show_weather.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocation
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(navHostController: NavHostController, weatherViewModel: WeatherViewModel = hiltViewModel()) {
    var mapProperties by remember {
        mutableStateOf(
            MapProperties(maxZoomPreference = 10f, minZoomPreference = 5f)
        )
    }
    var mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(mapToolbarEnabled = false)
        )
    }


    var selectedPoint by remember {
        mutableStateOf(
            ""
        )
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        GoogleMap(properties = mapProperties, uiSettings = mapUiSettings, onMapLongClick = {
            selectedPoint = it.toString()
        }) {
            MarkerShow(latLng = selectedPoint , navHostController)
        }
    }
}


@Composable
fun MarkerShow(
    latLng: String,
    navHostController: NavHostController,
) {


    if (latLng.isNotEmpty()) {
        var latString = latLng.substringBefore(",")
        var lat = latString.substringAfter("(").toDouble()
        var longStr = latLng.substringAfter(",")
        var long = longStr.substringBefore(")").toDouble()

        Marker(
            state = rememberMarkerState(position = LatLng(lat, long)),
            title = "Marker1",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
        )

        navHostController.navigate("weather_result/${lat.toString()}/${long.toString()}")
    }
}