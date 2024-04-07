package com.example.movieappmad24.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

class MovieViewModel : ViewModel() {
    private val movies = getMovies().associateWith { movie ->
        mutableStateOf(movie.isFavorite)
    }.toMutableMap()

    fun toggleFavorite(movie: Movie) {
        movies[movie]?.value = !(movies[movie]?.value ?: false)
    }

    fun isFavorite(movie: Movie): Boolean {
        return movies[movie]?.value ?: false
    }

    fun getFavoriteMovies(): List<Movie> {
        return movies.filter { it.value.value }.keys.toList()
    }
}