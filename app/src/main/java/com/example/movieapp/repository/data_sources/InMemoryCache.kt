package com.example.movieapp.repository.data_sources

import com.example.movieapp.model.Movie

object InMemoryCache {

    private val map = HashMap<String, List<Movie>>()

    fun saveData(key: String, value: List<Movie>) {
        if(map.containsKey(key))
            map.remove(key)
        map[key] = value
    }

    fun loadData(key: String): List<Movie> {
        return if(map.containsKey(key)) map[key]!!
        else emptyList()
    }
}