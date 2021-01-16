package com.example.movieapp.view

import com.example.movieapp.model.Movie

interface MoviesContract {
    interface View {
        fun showError(message: String)
        fun showMovieList(movies: List<Movie>)
        fun showMovieDetails(movie: Movie)
    }

    interface Presenter {
        fun setView(view: View)
        fun onViewCreated()
        fun onViewDestroyed()
        fun onMovieSelected(movie: Movie)
    }
}