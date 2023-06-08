package com.example.weatherapp.feature_show_weather.data.data_source

import com.example.weatherapp.feature_show_weather.domain.model.SelectedLocationWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/current.json")
    suspend fun getCurrentLocationWeather(@Query("key") key: String , @Query("q") queryParam: String , @Query("api") api : String = "yes") : Response<SelectedLocationWeather>

}