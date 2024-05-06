package com.example.movieappmad24.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieWithImages
import com.example.movieappmad24.models.getMovies
class MovieViewModel : ViewModel() {
    private val moviesWithImages = getMoviesWithImages().associateWith { movieWithImages ->
        mutableStateOf(movieWithImages.movie.isFavorite)
    }.toMutableMap()

    fun toggleFavorite(movieWithImages: MovieWithImages) {
        moviesWithImages[movieWithImages]?.value = !(moviesWithImages[movieWithImages]?.value ?: false)
    }

    fun isFavorite(movieWithImages: MovieWithImages): Boolean {
        return moviesWithImages[movieWithImages]?.value ?: false
    }

    fun getFavoriteMovies(): List<MovieWithImages> {
        return moviesWithImages.filter { it.value.value }.keys.toList()
    }

    fun getMoviesWithImages(): List<MovieWithImages> {
        return getMovies().map { movie ->
            MovieWithImages(movie, emptyList())
        }
    }
}