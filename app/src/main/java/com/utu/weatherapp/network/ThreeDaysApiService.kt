package com.utu.weatherapp.network

import com.utu.weatherapp.data.Model.ThreeDays
import retrofit2.http.GET
import retrofit2.http.Query

interface ThreeDaysApiService {


    /*  Three days data of each city  */

    @GET("data/2.5/forecast")
    suspend fun getMelbourneThreeDaysData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ): ThreeDays

    @GET("data/2.5/forecast")
    suspend fun getHobartThreeDaysData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ): ThreeDays


    @GET("data/2.5/forecast")
    suspend fun getPerthThreeDaysData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ): ThreeDays


    @GET("data/2.5/forecast")
    suspend fun getSydneyThreeDaysData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ): ThreeDays
}