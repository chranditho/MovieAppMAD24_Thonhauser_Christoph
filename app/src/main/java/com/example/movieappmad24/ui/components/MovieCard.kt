package com.example.movieappmad24.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.R

@Composable
fun MovieCard(innerPadding: PaddingValues) {
    var detailsVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Card() {
            Image(
                painter = painterResource(id = R.drawable.movie_image),
                contentDescription = "placeholder_image"
            )
            IconButton(onClick = { detailsVisible = !detailsVisible }) {
                Icon(
                    imageVector = if (detailsVisible) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse details"
                )
            }
            AnimatedVisibility(visible = detailsVisible) {
                Column(modifier = Modifier.animateContentSize()) {
                    Text("Director: Director Name")
                    Text("Release Year: 2022")
                    Text("Plot: This is the plot of the movie.")
                }
            }
        }
    }
}