import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun insert(movieImage: MovieImage) = movieDao.insert(movieImage)
    suspend fun update(movie: Movie) = movieDao.update(movie)
    suspend fun delete(movie: Movie) = movieDao.delete(movie)
    suspend fun getMovieById(id: Long) = movieDao.getMovieById(id)
    suspend fun getAllMovies() = movieDao.getAllMovies()
    suspend fun getFavoriteMovies() = movieDao.getFavoriteMovies()
    suspend fun getImagesByMovieId(movieId: Int) = movieDao.getImagesByMovieId(movieId)
}