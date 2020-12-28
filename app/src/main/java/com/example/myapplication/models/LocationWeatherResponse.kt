package com.example.pelotonapplication.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationWeatherResponse(
    @Json(name = "consolidated_weather")
    val weatherItems: List<LocationWeatherItem>
)
