package com.example.movieappmad24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.navigation.getCurrentScreen
import com.example.movieappmad24.ui.components.SimpleBottomAppBar
import com.example.movieappmad24.ui.components.SimpleTopAppBar
import com.example.movieappmad24.ui.screens.DetailScreen
import com.example.movieappmad24.ui.screens.HomeScreen
import com.example.movieappmad24.ui.screens.WatchlistScreen
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                val navController = rememberNavController()
                var movieTitle by remember { mutableStateOf("Movie Details") }
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            SimpleTopAppBar(
                                getTitle(navController, movieTitle),
                                onBackClick = { navController.popBackStack() })
                        },
                        bottomBar = { SimpleBottomAppBar(navController) },
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            NavHost(navController, startDestination = Screen.Home.route) {
                                composable(Screen.Home.route) {
                                    HomeScreen(navController)
                                }
                                composable(Screen.Detail.route) { backStackEntry ->
                                    val movieId = backStackEntry.arguments?.getString("movieId")
                                    val movie = getMovies().find { it.id == movieId }
                                    movieTitle = movie?.title ?: "Movie Details"
                                    if (movie != null) {
                                        DetailScreen(movie)
                                    }
                                }
                                composable(Screen.Watchlist.route) {
                                    WatchlistScreen()
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    @Composable
    private fun getTitle(
        navController: NavHostController,
        movieTitle: String
    ): String {
        val currentScreen = getCurrentScreen(navController)
        val title = when (currentScreen) {
            Screen.Home.route -> "Movie App"
            Screen.Watchlist.route -> "Your Watchlist"
            Screen.Detail.route -> movieTitle
            else -> "Movie App"
        }
        return title
    }
}
