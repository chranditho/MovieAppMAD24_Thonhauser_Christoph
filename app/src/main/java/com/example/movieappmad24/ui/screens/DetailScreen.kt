package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movieappmad24.models.MovieWithImages
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.ui.components.PlayerView
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun DetailScreen(movieWithImages: MovieWithImages, viewModel: MovieViewModel) {
    Column {
        MovieRow(movieWithImages, viewModel::isFavorite, viewModel::toggleFavorite)
        PlayerView(movieWithImages.movie.trailer)
        LazyRow(Modifier.padding(5.dp)) {
            items(movieWithImages.images) { movieImage ->
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    val painter: Painter = rememberAsyncImagePainter(
                        model = movieImage.url
                    )
                    Image(
                        painter = painter,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "Movie image"
                    )
                }
            }
        }
    }
}