package com.example.movieappmad24.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

class MovieViewModel : ViewModel() {
    val movies = getMovies().map { movie ->
        movie to mutableStateOf(movie.isFavorite)
    }.toMap().toMutableMap()

    fun toggleFavorite(movie: Movie) {
        movies[movie]?.value = !(movies[movie]?.value ?: false)
    }

    fun isFavorite(movie: Movie): Boolean {
        return movies[movie]?.value ?: false
    }
}