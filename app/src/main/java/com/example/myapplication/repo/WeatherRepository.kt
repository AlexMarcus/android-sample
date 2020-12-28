package com.example.myapplication.repo

import com.example.pelotonapplication.models.LocationWeatherItem
import io.reactivex.Single

interface WeatherRepository {

    fun getWeather(): Single<List<LocationWeatherItem>>
}