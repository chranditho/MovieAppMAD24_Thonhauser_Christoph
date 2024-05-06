package com.example.movieappmad24.viewmodels

import MovieRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val repository: MovieRepository) : ViewModel() {
     val movie = MutableLiveData<MovieWithImages>()

    fun getMovieById(id: Long) = viewModelScope.launch {
        movie.value = repository.getMovieById(id)
    }
}