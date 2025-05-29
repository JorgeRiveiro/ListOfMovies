package com.jriveiro.listofmovies.data.datasources

import com.jriveiro.listofmovies.domain.Movie
import com.jriveiro.listofmovies.data.datasources.remote.MoviesClient
import com.jriveiro.listofmovies.data.datasources.remote.RemoteMovie
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor() {

    suspend fun fetchPopularMovies(region: String): List<Movie> =
        MoviesClient.instance.fetchPopularMovies(region)
            .results
            .map { it.toDomainModel() }

    suspend fun findMovieById(id: Int): Movie =
        MoviesClient.instance.fetchMovieById(id).toDomainModel()
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