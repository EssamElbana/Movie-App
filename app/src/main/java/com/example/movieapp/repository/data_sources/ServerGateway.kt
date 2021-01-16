package com.example.movieapp.repository.data_sources

import com.example.movieapp.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.Exception

object ServerGateway {
    private const val baseUrl: String = "https://api.themoviedb.org/3/movie/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val retrofitObject by lazy {
        retrofit.create(
            MovieApi::class.java)
    }

    fun getMovies(): List<Movie> {
        try {
            val response = retrofitObject.getPopularMovies().execute()
            if(response.isSuccessful && response.body() != null)
                return response.body()!!.moviesList
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return emptyList()
    }
}