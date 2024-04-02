package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun WatchlistScreen(viewModel: MovieViewModel) {
    val movies = viewModel.getFavoriteMovies()

    Column {
        movies.forEach { movie ->
            MovieRow(movie, viewModel::isFavorite, viewModel::toggleFavorite)
        }
    }
}