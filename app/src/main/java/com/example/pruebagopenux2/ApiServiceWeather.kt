package com.example.pruebagopenux2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceWeather {
    @GET("onecall")
    fun getWeather(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("appid") apiKey: String = "e3d3795f74cd75a102f6ae7453201e96"): Call<WeatherResponse>
}

