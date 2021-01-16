package com.example.movieapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.repository.Repository
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMovies()
    }

    private fun getMovies() {
        GlobalScope.launch(Dispatchers.Main) {
            val movieList = withContext(Dispatchers.IO) {
                Repository.getMoviesList()
            }
            if (movieList.isEmpty())
                Toast.makeText(
                    this@MainActivity,
                    "Failed to retrieve popular movies!",
                    Toast.LENGTH_SHORT
                ).show()
            else {
                val movieAdapter =
                    MovieAdapter(movieList)
                val recyclerView: RecyclerView = findViewById(R.id.rvMovies)
                recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                recyclerView.addItemDecoration(
                    DividerItemDecoration(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL
                    )
                )
                recyclerView.adapter = movieAdapter
            }
        }
    }
}