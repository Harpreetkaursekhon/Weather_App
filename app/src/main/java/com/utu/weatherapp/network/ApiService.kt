package com.utu.weatherapp.network

import com.utu.weatherapp.data.Model.CurrentCity
import com.utu.weatherapp.data.Model.ThreeDays
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /* Current Data of each city */

    @GET("/data/2.5/weather")
    suspend fun getMelbourneData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ):CurrentCity

    @GET("/data/2.5/weather")
    suspend fun getHobartData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ):CurrentCity

    @GET("/data/2.5/weather")
    suspend fun getSydneyData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ):CurrentCity

    @GET("/data/2.5/weather")
    suspend fun getPerthData(
            @Query("q") q:String,
            @Query("appid") appId:String
    ):CurrentCity





}