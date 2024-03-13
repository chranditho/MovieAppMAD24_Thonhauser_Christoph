package com.example.movieappmad24.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

@Composable
fun DetailScreen(movie: Movie) {
    MovieRow(movie)
}

@Preview
@Composable
fun DetailScreenPreview() {
    MovieAppMAD24Theme {
        DetailScreen(movie = getMovies().first())
    }
}

