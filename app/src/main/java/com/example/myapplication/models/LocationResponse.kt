package com.example.myapplication.models

import com.squareup.moshi.JsonClass

//"title": "New York",
//"location_type": "City",
//"woeid": 2459115,
//"latt_long": "40.71455,-74.007118"

@JsonClass(generateAdapter = true)
data class LocationResponse(
    val title: String,
    val woeid: Int
)