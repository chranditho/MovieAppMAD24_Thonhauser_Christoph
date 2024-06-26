package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.viewmodels.MovieListViewModel

@Composable
fun WatchlistScreen(viewModel: MovieListViewModel) {
    val movies = viewModel.getFavoriteMovies()

    LazyColumn {
        items(movies) { movie ->
            val imageUrl =
                movie.images.firstOrNull { it.movieId == movie.movie.id }?.imageUrl ?: ""
            MovieRow(movie.movie, imageUrl, viewModel::toggleFavorite)
        }
    }
}