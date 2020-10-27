package bo.edu.data

import bo.edu.domain.Movie

class MoviesRepository(val remoteDataSource: IRemoteDataSource, val localDataSource: ILocalDataSource) {
    suspend fun getPopularMovies(): List<Movie> {
        return remoteDataSource.getPopularMovies()
    }

}
