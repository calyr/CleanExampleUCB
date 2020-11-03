package bo.edu.data

import bo.edu.domain.Movie

interface ILocalDataSource {
    fun getListPopularMovies(): List<Movie>

}
