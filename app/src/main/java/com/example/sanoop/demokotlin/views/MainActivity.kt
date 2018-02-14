package com.example.sanoop.demokotlin.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.sanoop.demokotlin.R
import com.example.sanoop.demokotlin.adapters.ForecastAdapter
import com.example.sanoop.demokotlin.databinding.ActivityMainBinding
import com.example.sanoop.demokotlin.models.ForecastModel
import com.example.sanoop.demokotlin.viewModels.ForecastViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var forecastList : List<ForecastModel>
    lateinit var adapter : ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val forecastViewModel = ViewModelProviders.of(this).get(ForecastViewModel::class.java)
        binding.rvForecast.layoutManager = LinearLayoutManager(this)
        forecastList = ArrayList<ForecastModel>()
        adapter = ForecastAdapter(forecastList)
        binding.rvForecast.adapter = adapter
        binding.progress.visibility = View.VISIBLE
        observeViewModel(forecastViewModel)
    }

    private fun observeViewModel(viewModel: ForecastViewModel) {
        viewModel.getWeatherSummary().observe(this, Observer { summary ->
            if (summary != null) {
                binding.progress.visibility = View.GONE
                binding.model = summary
                forecastList = summary.forecastModels
                adapter = ForecastAdapter(forecastList)
                binding.rvForecast.adapter = adapter
            } else {
                Toast.makeText(this, "Check you connection", Toast.LENGTH_LONG).show()
            }
        })
    }

}
