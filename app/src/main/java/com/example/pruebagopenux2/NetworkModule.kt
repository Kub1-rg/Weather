package com.example.pruebagopenux2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideApiService(): ApiService {
        return provideRetrofit("http://api.openweathermap.org/geo/1.0/").create(ApiService::class.java)
    }

    fun provideApiServiceWeather(): ApiServiceWeather {
        return provideRetrofit("https://api.openweathermap.org/data/3.0/").create(ApiServiceWeather::class.java)
    }
}
