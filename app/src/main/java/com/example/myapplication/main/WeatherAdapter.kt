package com.example.myapplication.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pelotonapplication.models.LocationWeatherItem

class WeatherAdapter : RecyclerView.Adapter<WeatherViewHolder>() {

    var items: List<LocationWeatherItem>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder.newInstance(parent)

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        items?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = items?.size ?: 0
}

