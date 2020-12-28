package com.example.myapplication.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repo.WeatherRepository
import com.example.pelotonapplication.models.LocationWeatherItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel(
    private val weatherRepo: WeatherRepository
): ViewModel() {

    private val disposables = CompositeDisposable()

    private val _weather = MutableLiveData<List<LocationWeatherItem>>()
    val weather: LiveData<List<LocationWeatherItem>> = _weather

    fun fetchWeather() {
        disposables += weatherRepo.getWeather()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { _weather.value = it }
            )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}