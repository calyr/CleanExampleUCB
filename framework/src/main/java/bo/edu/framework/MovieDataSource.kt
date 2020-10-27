package bo.edu.framework

import bo.edu.data.IRemoteDataSource
import bo.edu.domain.Movie

class MovieDataSource(val apiRest: RetrofitBuilder): IRemoteDataSource {
    override suspend fun getPopularMovies(): List<Movie> {
        val response = apiRest.apiService.listPopularMovies("")
            .results.map {
                it.toDomainMovie()
            }
        return response
    }
}