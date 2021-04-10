package com.utu.weatherapp.di

import com.utu.weatherapp.network.ApiService
import com.utu.weatherapp.network.ThreeDaysApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesUrl() = "http://api.openweathermap.org/"


    @Provides
    @Singleton
    fun providesRetrofitBuilder(url: String) =
            Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) =
            retrofit
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesThreeDaysService(retrofit: Retrofit) =
            retrofit
                    .create(ThreeDaysApiService::class.java)
}