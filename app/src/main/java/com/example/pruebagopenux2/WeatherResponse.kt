package com.example.pruebagopenux2

data class WeatherResponse(
        val current: CurrentWeather
)

data class CurrentWeather(
        val temp: Double,
        val feels_like: Double,
        val humidity: Double,
        val weather: List<WeatherInfo>
)

data class WeatherInfo(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)
