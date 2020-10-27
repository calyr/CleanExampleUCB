package bo.edu.framework

import bo.edu.domain.Movie as DomainMovie
import bo.edu.framework.server.Movie as ServerMovie

fun ServerMovie.toDomainMovie(): DomainMovie {
    return DomainMovie(title, posterPath)
}