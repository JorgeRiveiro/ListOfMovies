package com.jriveiro.listofmovies.framework

import com.jriveiro.data.datasource.MoviesRemoteDataSource
import com.jriveiro.domain.Movie
import com.jriveiro.listofmovies.framework.remote.MoviesService
import com.jriveiro.listofmovies.framework.remote.RemoteMovie
import javax.inject.Inject

class MoviesServerDataSource @Inject constructor(
    private val moviesService: MoviesService
) : MoviesRemoteDataSource {

    override suspend fun fetchPopularMovies(region: String): List<Movie> =
        moviesService.fetchPopularMovies(region)
            .results
            .map { it.toDomainModel() }

    override suspend fun findMovieById(id: Int): Movie =
        moviesService.fetchMovieById(id).toDomainModel()
}

private fun RemoteMovie.toDomainModel() = Movie(
    id,
    title,
    overview,
    releaseDate,
    "https://image.tmdb.org/t/p/w185/$posterPath",
    backdropPath?.let { "https://image.tmdb.org/t/p/w780/$it" },
    originalLanguage,
    originalTitle,
    popularity,
    voteAverage,
    false
)