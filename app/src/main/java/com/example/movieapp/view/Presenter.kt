package com.example.movieapp.view

import com.example.movieapp.model.Movie
import com.example.movieapp.repository.IRepository

class Presenter(private var repo: IRepository) :
    MoviesContract.Presenter {
    private val message = "Failed to retrieve popular movies!"
    private var view: MoviesContract.View? = null

    override fun setView(view: MoviesContract.View) {
        this.view = view
    }

    override fun onViewCreated() {
        var movies = repo.loadMovies()
        if (movies.isEmpty()) {
            movies = repo.getMoviesList()
            if (movies.isEmpty()) {
                view?.showError(message)
                return
            } else
                repo.saveMovies(movies)
        }
        view?.showMovieList(movies)
    }

    override fun onViewDestroyed() {
        view = null
    }

    override fun onMovieSelected(movie: Movie) {
        view?.showMovieDetails(movie)
    }

}