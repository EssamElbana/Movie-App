package com.example.movieapp.repository

import com.example.movieapp.model.Movie

interface IRepository {
    fun getMoviesList(): List<Movie>
    fun loadMovies(): List<Movie>
}