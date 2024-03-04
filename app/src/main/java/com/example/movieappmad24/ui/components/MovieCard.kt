package com.example.movieappmad24.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.R

@Composable
fun MovieCard(innerPadding: PaddingValues) {
    Column(
        modifier = androidx.compose.ui.Modifier.padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Card {
            Image(
                painter = painterResource(id = R.drawable.movie_image),
                contentDescription = "placeholder_image"
            )
        }
    }
}