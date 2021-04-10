package com.utu.weatherapp.network

import com.utu.weatherapp.data.Model.CurrentCity
import com.utu.weatherapp.data.Model.ThreeDays
import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService: ApiService) {

    suspend fun getMelbourneData(q:String,appId:String):CurrentCity =
            apiService.getMelbourneData(q,appId)

    suspend fun getHobartData(q:String,appId:String):CurrentCity =
            apiService.getMelbourneData(q,appId)

    suspend fun getSydneyData(q:String,appId:String):CurrentCity =
            apiService.getMelbourneData(q,appId)

    suspend fun getPerthData(q:String,appId:String):CurrentCity =
            apiService.getMelbourneData(q,appId)





}