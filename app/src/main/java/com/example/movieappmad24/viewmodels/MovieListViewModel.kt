package com.example.movieappmad24.viewmodels

import MovieRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.launch

class MovieListViewModel(private val repository: MovieRepository) : ViewModel() {
    private val allMovies = MutableLiveData<List<MovieWithImages>>()
    private val favoriteMovies = MutableLiveData<List<MovieWithImages>>()

    init {
        fetchAllMovies()
    }

    fun fetchAllMovies() = viewModelScope.launch {
        allMovies.value = repository.getAllMovies()
    }

    fun insert(movieWithImages: MovieWithImages) = viewModelScope.launch {
        repository.insert(movieWithImages)
    }

    fun getMovies() = allMovies.value.orEmpty()

    fun update(movieWithImages: MovieWithImages) = viewModelScope.launch {
        repository.update(movieWithImages)
    }

    fun toggleFavorite(movieWithImages: MovieWithImages) {
        val updatedMovie = movieWithImages.copy(movieWithImages.movie)
        updatedMovie.movie.isFavorite = !movieWithImages.movie.isFavorite
        update(updatedMovie)
    }

    fun getFavoriteMovies(): List<MovieWithImages> {
        return favoriteMovies.value.orEmpty()
    }
}