package com.example.movieappmad24.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "movies", indices = [Index(value = ["id"], unique = true)])
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val dbId: Long = 0L,
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val trailer: String,
    val rating: String,
    var isFavorite: Boolean = false
)

fun getMovies(): List<MovieWithImages> {
    return listOf(
        MovieWithImages(
            Movie(
                id = "tt0499549",
                title = "Avatar",
                year = "2009",
                genre = "Action, Adventure, Fantasy",
                director = "James Cameron",
                actors = "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
                plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                trailer = "trailer_placeholder",
                rating = "7.9"
            ),
            images = listOf(
                MovieImage(
                    movieId = "tt0499549",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0499549",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BNzM2MDk3MTcyMV5BMl5BanBnXkFtZTcwNjg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0499549",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2ODQ3NjMyMl5BMl5BanBnXkFtZTcwODg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0499549",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxOTEwNDcxN15BMl5BanBnXkFtZTcwOTg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0499549",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMDg1Nzk1MV5BMl5BanBnXkFtZTcwMDk0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg"
                )
            )
        ),
        MovieWithImages(
            Movie(
                id = "tt0416449",
                title = "300",
                year = "2006",
                genre = "Action, Drama, Fantasy",
                director = "Zack Snyder",
                actors = "Gerard Butler, Lena Headey, Dominic West, David Wenham",
                plot = "King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.",
                trailer = "trailer_placeholder",
                rating = "7.7"
            ),
            images = listOf(
                MovieImage(
                    movieId = "tt0416449",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTMwNTg5MzMwMV5BMl5BanBnXkFtZTcwMzA2NTIyMw@@._V1_SX1777_CR0,0,1777,937_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0416449",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQwNTgyNTMzNF5BMl5BanBnXkFtZTcwNDA2NTIyMw@@._V1_SX1777_CR0,0,1777,935_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0416449",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MjQzOTEwMV5BMl5BanBnXkFtZTcwMzE2NTIyMw@@._V1_SX1777_CR0,0,1777,947_AL_.jpg"
                )
            )
        ),
        MovieWithImages(
            Movie(
                id = "tt0848228",
                title = "The Avengers",
                year = "2012",
                genre = "Action, Sci-Fi, Thriller",
                director = "Joss Whedon",
                actors = "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth",
                plot = "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
                trailer = "trailer_placeholder",
                rating = "8.1"
            ),
            images = listOf(
                MovieImage(
                    movieId = "tt0848228",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0NjY0NzE4OTReQTJeQWpwZ15BbWU3MDczODg2Nzc@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0848228",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE1MzEzMjcyM15BMl5BanBnXkFtZTcwNDM4ODY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0848228",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTjA0NjY0NzE4OTReQTJeQWpwZ15BbWU3MDczODg2Nzc@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0848228",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0NjY0NzE4OTReQTJeQWpwZ15BbWU3MDczODg2Nzc@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                ),
                MovieImage(
                    movieId = "tt0848228",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0NjY0NzE4OTReQTJeQWpwZ15BbWU3MDczODg2Nzc@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                )
            )
        )
    )
}