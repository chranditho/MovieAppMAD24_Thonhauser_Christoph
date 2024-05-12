package com.example.movieappmad24.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "images",
    foreignKeys = [ForeignKey(
        entity = Movie::class,
        parentColumns = ["id"],
        childColumns = ["movieId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class MovieImage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val movieId: String,
    val imageUrl: String
)