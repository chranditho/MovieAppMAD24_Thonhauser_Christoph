package com.example.movieappmad24.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

@Composable
fun DetailScreen(movie: Movie, navController: NavController) {
    MovieRow(movie)
}

@Preview
@Composable
fun DetailScreenPreview() {
    MovieAppMAD24Theme {
        val navController = rememberNavController()
        DetailScreen(movie = getMovies().first(), navController = navController)
    }
}

