package bo.edu.usecases

import bo.edu.domain.Movie
import bo.edu.data.MoviesRepository

class GetPopularMovie(val moviesRepository: MoviesRepository) {
    suspend fun invoke(): List<Movie> = moviesRepository.getPopularMovies()
}