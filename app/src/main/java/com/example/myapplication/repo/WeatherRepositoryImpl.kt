package com.example.myapplication.repo

import com.example.myapplication.network.WeatherApiService
import com.example.myapplication.models.LocationResponse
import com.example.pelotonapplication.models.LocationWeatherItem
import io.reactivex.Single
import java.lang.RuntimeException

class WeatherRepositoryImpl(
    private val apiService: WeatherApiService
): WeatherRepository {

    private val locationName = "los angeles"

    override fun getWeather(): Single<List<LocationWeatherItem>> =
        getLocationInfo()
            .flatMap {
                it.firstOrNull()?.let { location ->
                    apiService.getWeatherForLocation(location.woeid)
                } ?: Single.error(RuntimeException("There was an error fetching weather data"))
            }
            .map { it.weatherItems }

    private fun getLocationInfo(): Single<List<LocationResponse>> =
        apiService.getLocationInfo(locationName)
}