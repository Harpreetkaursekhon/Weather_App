package com.utu.weatherapp.Repository

import com.utu.weatherapp.data.Model.CurrentCity
import com.utu.weatherapp.data.Model.ThreeDays
import com.utu.weatherapp.network.ApiServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository  @Inject constructor(private val apiServiceImp: ApiServiceImp) {

     fun getMelbourneData(
             q:String
     ):Flow<CurrentCity> = flow {
         emit(apiServiceImp.getMelbourneData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
     }.flowOn(Dispatchers.IO)


    fun getHobartData(
            q:String
    ):Flow<CurrentCity> = flow {
        emit(apiServiceImp.getHobartData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
    }.flowOn(Dispatchers.IO)


    fun getSydneyData(
            q:String
    ):Flow<CurrentCity> = flow {
        emit(apiServiceImp.getSydneyData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
    }.flowOn(Dispatchers.IO)


    fun getPerthData(
            q:String
    ):Flow<CurrentCity> = flow {
        emit(apiServiceImp.getPerthData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
    }.flowOn(Dispatchers.IO)




}