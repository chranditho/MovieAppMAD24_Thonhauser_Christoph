package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.components.MovieList
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ), title = {
                Text(
                    "Movie App",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            })
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                NavigationBar {
                    NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                    }, label = {
                        Text("Home")
                    })
                    NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "Watchlist")
                    }, label = {
                        Text("Watchlist")
                    })
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            MovieList()
        }
    }

}


@Preview
@Composable
fun DefaultPreview() {
    MovieAppMAD24Theme {
        MovieList(movies = getMovies())
    }
}

