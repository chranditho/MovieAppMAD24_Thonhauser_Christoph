package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: MovieViewModel) {
    val movies = getMovies()
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie, viewModel::isFavorite, viewModel::toggleFavorite) { selectedMovie ->
                navController.navigate("detail/${selectedMovie.id}")
            }
        }
    }
}

