package com.example.weatherapp.feature_show_weather.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun MainScreen(mainActivity: MainActivity) {
    val navController = rememberNavController()

    WeatherAppTheme {

        Scaffold(
            topBar = {
            },
            bottomBar = {
            }
        ) { contentPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(contentPadding)
            )
            {
                composable("home") {
                    HomeScreen(navController)
                }

                composable(
                    "map",
                ) {
                }

                composable(
                    "weather_result/{lat}/{long}",
                    arguments = listOf(navArgument("lat") { type = NavType.StringType } , navArgument("long") { type = NavType.StringType })
                ) {

                }
            }
        }



    }

}