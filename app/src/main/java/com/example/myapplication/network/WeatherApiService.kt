package com.example.myapplication.network

import com.example.myapplication.models.LocationResponse
import com.example.pelotonapplication.models.LocationWeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiService {
    @GET("api/location/search")
    fun getLocationInfo(@Query("query") locationName: String) : Single<List<LocationResponse>>

    @GET("api/location/{woeid}")
    fun getWeatherForLocation(@Path("woeid") woeid: Int) : Single<LocationWeatherResponse>

}