package com.example.pruebagopenux2

import com.google.gson.annotations.SerializedName
import retrofit2.Response

data class  CityResponse (
    @SerializedName("name") val name :String,
    @SerializedName("lat") var lat :Double,
    @SerializedName("lon") var lon :Double
        )