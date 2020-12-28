package com.example.myapplication.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ViewholderWeatherItemBinding
import com.example.pelotonapplication.models.LocationWeatherItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WeatherViewHolder(private val binding: ViewholderWeatherItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(
            parent: ViewGroup
        ): WeatherViewHolder = WeatherViewHolder(
            ViewholderWeatherItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun bind(item: LocationWeatherItem) {
        val date = LocalDate.parse(item.date)
        val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
        val formattedDate = date.format(formatter)

        binding.weatherText.text =
            itemView.context.getString(R.string.weather, formattedDate, item.temp)

    }

}