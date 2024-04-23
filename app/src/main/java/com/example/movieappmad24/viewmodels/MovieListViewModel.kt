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

    private fun fetchAllMovies() = viewModelScope.launch {
        allMovies.value = repository.getAllMovies()
    }

    fun insert(movie: Movie) = viewModelScope.launch {
        repository.insert(movie)
    }
}