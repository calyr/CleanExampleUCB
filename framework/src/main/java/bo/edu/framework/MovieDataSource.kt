package bo.edu.framework

import bo.edu.data.IRemoteDataSource
import bo.edu.domain.Movie

class MovieDataSource(val apiRest: RetrofitBuilder, val apiKey: String): IRemoteDataSource {
    override suspend fun getPopularMovies(): List<Movie> {
        val response = apiRest.apiService.listPopularMovies(apiKey)
            .results.map {
                it.toDomainMovie()
            }
        return response
    }
}