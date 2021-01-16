package com.example.movieapp.repository.data_sources

import com.example.movieapp.model.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

const val API_KEY = "dd05a2634ac8b2d4d727b15a62af578d"
interface MovieApi {
    @GET("popular?api_key=$API_KEY")
    fun getPopularMovies(): Call<PopularMoviesResponse>
}