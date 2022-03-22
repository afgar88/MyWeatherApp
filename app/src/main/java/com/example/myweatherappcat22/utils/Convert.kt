package com.example.myweatherappcat22.utils

import com.example.myweatherappcat22.model.Forecast
import com.example.myweatherappcat22.model.Main
import java.text.SimpleDateFormat
import java.util.*


fun Main.fTemp(): String = ktoF(this.temp).toString()+" F"

fun ktoF(k: Double): Int = (((k - 273.5) * 1.8) + 32).toInt()

fun Forecast.hour(pattern: String = "HH:mm"): String {
    val formatter = SimpleDateFormat(pattern)
    val date = Date(this.dt.toLong() * 1000)
    return formatter.format(date)
}


