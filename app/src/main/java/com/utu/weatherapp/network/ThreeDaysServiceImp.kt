package com.utu.weatherapp.network

import com.utu.weatherapp.data.Model.ThreeDays
import javax.inject.Inject

class ThreeDaysServiceImp
@Inject
constructor(private val threeDaysApiService: ThreeDaysApiService) {

    suspend fun getMelbourneThreeDaysData(q:String,appId:String): ThreeDays =
            threeDaysApiService.getMelbourneThreeDaysData(q,appId)

    suspend fun getHobartThreeDaysData(q:String,appId:String): ThreeDays =
            threeDaysApiService.getMelbourneThreeDaysData(q,appId)

    suspend fun getPerthThreeDaysData(q:String,appId:String): ThreeDays =
            threeDaysApiService.getMelbourneThreeDaysData(q,appId)

    suspend fun getSydneyThreeDaysData(q:String,appId:String): ThreeDays =
            threeDaysApiService.getMelbourneThreeDaysData(q,appId)
}