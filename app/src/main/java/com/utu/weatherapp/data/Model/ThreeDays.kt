package com.utu.weatherapp.data.Model

data class ThreeDays(
        val cod:String,
        val list:List<Temp>,
)

data class Temp(
        val dt_txt:String,
        val main:Main2
)

data class Main2(
        val temp:Double
)