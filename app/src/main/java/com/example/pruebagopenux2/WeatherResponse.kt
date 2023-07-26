package com.example.pruebagopenux2

data class WeatherResponse(
        val current: CurrentWeather
)

data class CurrentWeather(
        val temp: Double,
        val feels_like: Double,
        val humidity: Int
)
