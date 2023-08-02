package com.example.pruebagopenux2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("direct")
    fun getLatAndLon(
        @Query("q") ciudad: String,
        @Query("limit") limit: Int = 5,
        @Query("appid") apiKey: String = "e3d3795f74cd75a102f6ae7453201e96"
    ): Call<List<CityResponse>>
}
