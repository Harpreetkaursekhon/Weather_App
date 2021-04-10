package com.utu.weatherapp.data.Model


data class CurrentCity(
        val name: String,
        val wind: Wind,
        val main: Main,
        val weather:List<Weather>
)

data class Wind(
        val degree: Int
)

data class Main(
        val temp_min:Double,
        val temp_max:Double,
        val temp:Double
)

data class Weather(
        val description:String
)