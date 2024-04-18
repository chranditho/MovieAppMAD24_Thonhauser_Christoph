import com.example.movieappmad24.models.Movie

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun insert(movie: Movie) = movieDao.insert(movie)
    suspend fun update(movie: Movie) = movieDao.update(movie)
    suspend fun delete(movie: Movie) = movieDao.delete(movie)
    suspend fun getMovieById(id: Long) = movieDao.getMovieById(id)
    suspend fun getAllMovies() = movieDao.getAllMovies()
    suspend fun getFavoriteMovies() = movieDao.getFavoriteMovies()
}