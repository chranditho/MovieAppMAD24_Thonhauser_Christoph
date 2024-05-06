package com.example.movieappmad24.viewmodels

import MovieRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(private val repository: MovieRepository) : ViewModel() {
    private val allMovies = MutableLiveData<List<Movie>>()

    init {
        fetchAllMovies()
    }

    fun fetchAllMovies() = viewModelScope.launch {
        allMovies.value = repository.getAllMovies()
    }

    fun insert(movie: Movie) = viewModelScope.launch {
        repository.insert(movie)
    }

    fun getMovies() = allMovies.value.orEmpty()

    fun update(movie: Movie) = viewModelScope.launch {
        repository.update(movie)
    }

    fun toggleFavorite(movie: Movie) {
        val updatedMovie = movie.copy(isFavorite = !movie.isFavorite)
        update(updatedMovie)
    }

    fun getFavoriteMovies(): List<Movie> {
        return getMovies().filter { it.isFavorite }
    }
}