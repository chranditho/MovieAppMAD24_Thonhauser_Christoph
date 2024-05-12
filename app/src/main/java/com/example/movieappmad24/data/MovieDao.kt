import androidx.room.*
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage
import com.example.movieappmad24.models.MovieWithImages

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<MovieImage>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(images: List<Movie>)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Update
    suspend fun updateImages(images: List<MovieImage>)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Delete
    suspend fun deleteImages(images: List<MovieImage>)

    @Query("SELECT * FROM movies WHERE dbId = :id")
    suspend fun getMovieWithImagesById(id: Long): MovieWithImages

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<MovieWithImages>

    @Query("SELECT * FROM movies WHERE isFavorite = 1")
    suspend fun getFavoriteMovies(): List<MovieWithImages>
}