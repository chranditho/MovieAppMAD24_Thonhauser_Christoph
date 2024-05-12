package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.viewmodels.MovieListViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: MovieListViewModel) {
    val movies = viewModel.getMovies()
    LazyColumn {
        items(movies) { movie ->
            val imageUrl =
                movie.images.firstOrNull { it.movieId == movie.movie.id }?.imageUrl ?: "";
            MovieRow(movie.movie, imageUrl, { selectedMovie ->
                navController.navigate("detail/${selectedMovie.id}")
            })
        }
    }
}
