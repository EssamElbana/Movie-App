package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // sample url.
        // https://api.themoviedb.org/3/movie/popular?api_key=dd05a2634ac8b2d4d727b15a62af578d"
        /* Instantiates headerAdapter and flowersAdapter. Both adapters are added to concatAdapter.
        which displays the contents sequentially */
        val movieList = ArrayList<Movie>()
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        movieList.add(Movie("https://image.tmdb.org/t/p/w500/t7EUMSlfUN3jUSZUJOLURAzJzZs.jpg"))
//        val baseUrl = "https://api.themoviedb.org/3/movie/popular?api_key=dd05a2634ac8b2d4d727b15a62af578d"

        val call = ServerGateway.createService(MovieApi::class.java)
        call.getPopularMovies().enqueue(object : Callback<PopularMoviesResponse> {
            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<PopularMoviesResponse>,
                response: Response<PopularMoviesResponse>
            ) {
                if(response.body() != null) {
                    val movieAdapter = MovieAdapter(response.body()!!.moviesList)
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
        })

    }
}