package com.example.movieapp


data class Movie(
    val id: String,
    val title: String,
    val poster_path: String? = "",
    val overview: String,
    val release_date: String) {
    fun getImageURL(): String {
        return "https://image.tmdb.org/t/p/w500$poster_path"
    }
}