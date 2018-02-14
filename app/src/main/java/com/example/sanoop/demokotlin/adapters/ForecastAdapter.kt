package com.example.sanoop.demokotlin.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sanoop.demokotlin.BR
import com.example.sanoop.demokotlin.R
import com.example.sanoop.demokotlin.models.ForecastModel

/**
 * Created by C149306 on 14-02-2018.
 */

class ForecastAdapter(private val forecasts: List<ForecastModel>) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(forecasts[position])
    }

    override fun getItemCount(): Int {
        return forecasts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val viewBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent?.getContext()), R.layout.row_forecast, parent, false)
        return ViewHolder(viewBinding)
    }


    class ViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(forecastModel: ForecastModel){
            binding.setVariable(BR.forecast, forecastModel)
        }
    }

}
