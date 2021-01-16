package com.example.movieapp.view

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import com.example.movieapp.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity(), MoviesContract.View {
    private val presenter by lazy {
        Presenter(Repository)
    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movieAdapter =
            MovieAdapter(onItemClicked = {
                presenter.onMovieSelected(it)
            })
        val columns = (resources.displayMetrics.widthPixels  / 360)
        rvMovies.layoutManager = GridLayoutManager(this@MainActivity, columns)
        rvMovies.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
        )
        rvMovies.adapter = movieAdapter
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                presenter.onViewCreated()
            }
        }
    }

    override fun showMovieDetails(movie: Movie) {
        val fragmentManager: FragmentManager = supportFragmentManager
        MovieDetailsDialog().apply {
            initMovie(movie)
        }.show(fragmentManager, "MOVIE DETAILS DIALOG")
    }

    override fun showError(message: String) {
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@MainActivity,
                    message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun showMovieList(movies: List<Movie>) {
        GlobalScope.launch {
            withContext(Dispatchers.Main) {

                val adapter = rvMovies.adapter as MovieAdapter
                adapter.setDataSet(movies)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.onViewDestroyed()
    }
}