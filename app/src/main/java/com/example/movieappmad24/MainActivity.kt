package com.example.movieappmad24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.screens.DetailScreen
import com.example.movieappmad24.ui.screens.HomeScreen
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ), navigationIcon = {
                                IconButton(onClick = { navController.popBackStack() }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Go back"
                                    )
                                }
                            }, title = {
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
                                    NavigationBarItem(selected = true,
                                        onClick = { /*TODO*/ },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Home,
                                                contentDescription = "Home"
                                            )
                                        },
                                        label = {
                                            Text("Home")
                                        })
                                    NavigationBarItem(selected = false,
                                        onClick = { /*TODO*/ },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Watchlist"
                                            )
                                        },
                                        label = {
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
                            NavHost(navController, startDestination = "home") {
                                composable("home") {
                                    HomeScreen(navController)
                                }
                                composable("detail/{movieId}") { backStackEntry ->
                                    val movieId = backStackEntry.arguments?.getString("movieId")
                                    val movie = getMovies().find { it.id == movieId }
                                    if (movie != null) {
                                        DetailScreen(movie)
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}
