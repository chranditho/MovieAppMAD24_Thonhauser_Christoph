package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.components.MovieRow

@Composable
fun WatchlistScreen() {
    val movies = getMovies().subList(3, 5)

    Column {
        movies.forEach { movie ->
            MovieRow(movie)
        }
    }
}