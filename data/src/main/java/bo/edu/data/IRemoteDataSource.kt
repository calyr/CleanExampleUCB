package bo.edu.data

import bo.edu.domain.Movie

interface IRemoteDataSource {
    fun getPopularMovies(): List<Movie>
}