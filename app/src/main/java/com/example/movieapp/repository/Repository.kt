package com.example.movieapp.repository

import com.example.movieapp.repository.data_sources.InMemoryCache
import com.example.movieapp.repository.data_sources.ServerGateway
import com.example.movieapp.model.Movie

object Repository : IRepository {
    private val serverGateway =
        ServerGateway
    private val inMemoryCache =
        InMemoryCache
    private const val moviesListKey = "MOVIES_LIST"

    override fun getMoviesList(): List<Movie> = serverGateway.getMovies()

    override fun loadMovies(): List<Movie> = inMemoryCache.loadData(moviesListKey)

}