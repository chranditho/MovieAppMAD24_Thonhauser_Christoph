import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage
import com.example.movieappmad24.models.MovieWithImages

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieImage: MovieImage)

    @Query("SELECT * FROM MovieImage WHERE movieId = :movieId")
    suspend fun getImagesByMovieId(movieId: Int): List<MovieImage>

    @Update
    suspend fun update(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("SELECT * FROM movies WHERE dbId = :id")
    suspend fun getMovieById(id: Long): MovieWithImages

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<MovieWithImages>

    @Query("SELECT * FROM movies WHERE isFavorite = 1")
    suspend fun getFavoriteMovies(): List<Movie>
}