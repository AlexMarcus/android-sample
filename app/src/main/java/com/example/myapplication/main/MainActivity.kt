package com.example.myapplication.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.network.RetrofitBuilder
import com.example.myapplication.repo.WeatherRepositoryImpl
import com.example.myapplication.view_model.MainViewModelFactory
import com.example.pelotonapplication.models.LocationWeatherItem

class MainActivity : AppCompatActivity() {

    private val viewModelFactory =
        MainViewModelFactory(WeatherRepositoryImpl(RetrofitBuilder.buildApiService()))
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    lateinit var binding: ActivityMainBinding
    private val adapter = WeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        initView()
        initViewModel()
    }

    private fun initView() {
        binding.recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.weather.observe(this, ::handleWeatherItems)

        viewModel.fetchWeather()
    }

    private fun handleWeatherItems(items: List<LocationWeatherItem>?) { adapter.items = items }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}