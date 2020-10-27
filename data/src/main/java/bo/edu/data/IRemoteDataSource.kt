package bo.edu.data

import bo.edu.domain.Movie

interface IRemoteDataSource {
    suspend fun getPopularMovies(): List<Movie>
}