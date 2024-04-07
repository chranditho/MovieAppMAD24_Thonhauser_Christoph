package com.example.movieappmad24.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.rememberAsyncImagePainter
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.components.MovieRow
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun DetailScreen(movie: Movie, viewModel: MovieViewModel) {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(movie.trailer, "raw", context.packageName)
    val uri = Uri.parse("android.resource://${context.packageName}/$resourceId")
    val mediaItem = MediaItem.fromUri(uri)

    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(mediaItem)
            prepare()
        }
    }
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    LaunchedEffect(player) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> player.play()
                Lifecycle.Event.ON_STOP -> player.pause()
                else -> Unit
            }
        }
        lifecycle.addObserver(lifecycleObserver)
    }



    Column {
        MovieRow(movie, viewModel::isFavorite, viewModel::toggleFavorite)
        LazyRow(Modifier.padding(5.dp)) {
            items(movie.images) { imageUrl ->
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    val painter: Painter = rememberAsyncImagePainter(
                        model = imageUrl
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
        Row {
            AndroidView({ context ->
                val playerView = PlayerView(context)
                playerView.player = player
                playerView
            }, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    MovieAppMAD24Theme {
        DetailScreen(movie = getMovies().first(), viewModel = MovieViewModel())
    }
}

