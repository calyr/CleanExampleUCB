package bo.edu.data

import bo.edu.domain.Movie

class MoviesRepository(val remoteDataSource: IRemoteDataSource) {
    fun getPopularMovies(): List<Movie> = remoteDataSource.getPopularMovies()

}
