package com.example.movieappmad24.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun MovieList(movies: List<Movie> = getMovies(), viewModel: MovieViewModel) {
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie, viewModel)
        }
    }
}