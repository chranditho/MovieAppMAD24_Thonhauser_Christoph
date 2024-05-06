package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun WatchlistScreen(viewModel: MovieViewModel) {
    val moviesWithImages = viewModel.getFavoriteMovies()
    LazyColumn {
        items(moviesWithImages) { movieWithImages ->
            MovieRow(movieWithImages, viewModel::isFavorite, viewModel::toggleFavorite)
        }
    }
}