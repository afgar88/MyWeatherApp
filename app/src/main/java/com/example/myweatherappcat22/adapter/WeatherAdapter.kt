package com.example.myweatherappcat22.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherappcat22.databinding.ForcastItemBinding
import com.example.myweatherappcat22.model.Forecast
import com.example.myweatherappcat22.model.Main
import com.example.myweatherappcat22.utils.fTemp
import com.example.myweatherappcat22.utils.hour

class WeatherAdapter(
    private val forecastList: MutableList<Forecast> = mutableListOf(),
    private val clickDetail: (forecast: Forecast) -> Unit
) : RecyclerView.Adapter<ForecastViewHolder>() {

    fun setForecast(newForecast: List<Forecast>) {
        forecastList.clear()
        forecastList.addAll(newForecast)
        notifyItemRangeChanged(0, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = ForcastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastViewHolder(view, clickDetail)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) =
        holder.bind(forecastList[position])

    override fun getItemCount(): Int = forecastList.size
}

class ForecastViewHolder(
    private val binding: ForcastItemBinding,
   private val clickDetail: (forecast: Forecast) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(forecast: Forecast) {
        binding.hour.text = forecast.hour()
        binding.temp.text = forecast.main.fTemp()
        binding.desc.text = forecast.weather[0].description
        binding.root.setOnClickListener{clickDetail(forecast)}

    }

}