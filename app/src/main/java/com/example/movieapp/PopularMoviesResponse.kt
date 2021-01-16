package com.example.movieapp

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(
    @SerializedName("results")
    @Expose
    val moviesList: List<Movie>)