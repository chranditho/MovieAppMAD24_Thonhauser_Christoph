package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun WatchlistScreen(viewModel: MovieViewModel) {
    val movies = viewModel.getFavoriteMovies()

    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie, viewModel::isFavorite, viewModel::toggleFavorite)
        }
    }
}