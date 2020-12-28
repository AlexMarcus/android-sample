package com.example.pelotonapplication.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationWeatherItem(
    @Json(name = "the_temp")
    val temp: Double,
    @Json(name = "applicable_date")
    val date: String
)