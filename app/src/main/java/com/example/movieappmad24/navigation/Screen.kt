package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Detail : Screen("detail/{movieId}")
    data object Watchlist : Screen("watchlist")
}