package bo.edu.data

import bo.edu.domain.Movie

class MoviesRepository(val remoteDataSource: IRemoteDataSource) {
    suspend fun getPopularMovies(): List<Movie> {
        return remoteDataSource.getPopularMovies()
    }

}
