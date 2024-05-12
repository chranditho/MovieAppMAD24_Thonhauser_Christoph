import com.example.movieappmad24.models.MovieWithImages

class MovieRepository(private val movieDao: MovieDao) {

    suspend fun insertMovieWithImages(movieWithImages: MovieWithImages) {
        movieDao.insertMovie(movieWithImages.movie)
        movieDao.insertImages(movieWithImages.images)
    }

    suspend fun insert(movieWithImages: MovieWithImages) {
        movieDao.insertMovie(movieWithImages.movie)
        movieDao.insertImages(movieWithImages.images)
    }

    suspend fun update(movieWithImages: MovieWithImages) {
        movieDao.updateMovie(movieWithImages.movie)
        movieDao.updateImages(movieWithImages.images)
    }

    suspend fun delete(movieWithImages: MovieWithImages) {
        movieDao.deleteMovie(movieWithImages.movie)
        movieDao.deleteImages(movieWithImages.images)
    }

    suspend fun getMovieById(id: Long) = movieDao.getMovieWithImagesById(id)
    suspend fun getAllMovies() = movieDao.getAllMovies()
    suspend fun getFavoriteMovies() = movieDao.getFavoriteMovies()
}