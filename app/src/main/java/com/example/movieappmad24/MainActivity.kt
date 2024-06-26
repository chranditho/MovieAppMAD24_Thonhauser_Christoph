package com.example.movieappmad24

import MovieDatabase
import MovieRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import com.example.movieappmad24.viewmodels.MovieDetailViewModel
import com.example.movieappmad24.viewmodels.MovieDetailViewModelFactory
import com.example.movieappmad24.viewmodels.MovieListViewModel
import com.example.movieappmad24.viewmodels.MovieListViewModelFactory

class MainActivity : ComponentActivity() {
    private val movieListViewModel: MovieListViewModel by viewModels {
        MovieListViewModelFactory(MovieRepository(MovieDatabase.getDatabase(this).movieDao()))
    }

    private val movieDetailViewModel: MovieDetailViewModel by viewModels {
        MovieDetailViewModelFactory(MovieRepository(MovieDatabase.getDatabase(this).movieDao()))
    }

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
                                    HomeScreen(navController, movieListViewModel)
                                }
                                composable(Screen.Detail.route) { backStackEntry ->
                                    val movieId = backStackEntry.arguments?.getString("movieId")
                                    val movie = getMovies().find { it.movie.id == movieId }
                                    movieTitle = movie?.movie?.title ?: "Movie Details"
                                    if (movie != null) {
                                        DetailScreen(movie, movieDetailViewModel)
                                    }
                                }
                                composable(Screen.Watchlist.route) {
                                    WatchlistScreen(movieListViewModel)
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