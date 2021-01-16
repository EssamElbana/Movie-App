package com.example.movieapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServerGateway {
    private const val baseUrl: String = "https://api.themoviedb.org/3/movie/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(t: Class<T>): T {
        return retrofit.create(t)
    }
}