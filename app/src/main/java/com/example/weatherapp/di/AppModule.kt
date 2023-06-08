package com.example.weatherapp.di

import android.content.Context
import com.example.weatherapp.feature_show_weather.data.data_source.WeatherApi
import com.example.weatherapp.feature_show_weather.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.feature_show_weather.domain.repository.WeatherRepository
import com.example.weatherapp.feature_show_weather.domain.use_case.LocationWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherRepositoryImpl(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi)
    }

    @Provides
    @Singleton
    fun provideLocationWeatherUseCase(weatherRepository: WeatherRepository): LocationWeatherUseCase {
        return LocationWeatherUseCase(weatherRepository)
    }

}