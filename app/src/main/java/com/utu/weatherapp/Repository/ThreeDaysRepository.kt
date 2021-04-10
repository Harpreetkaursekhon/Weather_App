package com.utu.weatherapp.Repository

import com.utu.weatherapp.data.Model.ThreeDays
import com.utu.weatherapp.network.ApiServiceImp
import com.utu.weatherapp.network.ThreeDaysServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ThreeDaysRepository @Inject
constructor(private val threeDaysApiServiceImp: ThreeDaysServiceImp){

    fun getMelbourneThreeDaysData(
            q:String
    ): Flow<ThreeDays> = flow {
        emit(threeDaysApiServiceImp.getMelbourneThreeDaysData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
    }.flowOn(Dispatchers.IO)


    fun getHobartThreeDaysData(
            q:String
    ): Flow<ThreeDays> = flow {
        emit(threeDaysApiServiceImp.getHobartThreeDaysData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
    }.flowOn(Dispatchers.IO)

    fun getPerthThreeDaysData(
            q:String
    ): Flow<ThreeDays> = flow {
        emit(threeDaysApiServiceImp.getPerthThreeDaysData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
    }.flowOn(Dispatchers.IO)


    fun getSydneyThreeDaysData(
            q:String
    ): Flow<ThreeDays> = flow {
        emit(threeDaysApiServiceImp.getSydneyThreeDaysData(q,"fa6d9f4e7f0a189f66a92e46b77b078c"))
    }.flowOn(Dispatchers.IO)
}