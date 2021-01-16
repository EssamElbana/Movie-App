package com.example.movieapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

const val API_KEY = "dd05a2634ac8b2d4d727b15a62af578d"

interface MovieApi {
    // sample url.
    // popular?api_key=dd05a2634ac8b2d4d727b15a62af578d"
    @GET("popular?api_key=${API_KEY}")
    fun getPopularMovies(): Call<PopularMoviesResponse>
}