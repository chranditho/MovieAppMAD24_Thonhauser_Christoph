package com.example.movieappmad24.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.navigation.getCurrentScreen

@Composable
fun SimpleBottomAppBar(navController: NavController) {
    val currentScreen = getCurrentScreen(navController)

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        NavigationBar {
            NavigationBarItem(
                selected = currentScreen == Screen.Home.route,
                onClick = { navController.navigate(Screen.Home.route) },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home"
                    )
                },
                label = {
                    Text("Home")
                }
            )
            NavigationBarItem(
                selected = currentScreen == Screen.Watchlist.route,
                onClick = { navController.navigate(Screen.Watchlist.route) },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Watchlist"
                    )
                },
                label = {
                    Text("Watchlist")
                }
            )
        }
    }
}