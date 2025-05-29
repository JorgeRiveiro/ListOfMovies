package com.jriveiro.listofmovies.data.datasources

import com.jriveiro.listofmovies.data.datasources.database.DbMovie
import com.jriveiro.listofmovies.domain.Movie
import com.jriveiro.listofmovies.data.datasources.database.MoviesDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface MoviesLocalDataSource {
    val movies: Flow<List<Movie>>
    fun findMovieById(id: Int): Flow<Movie?>

    suspend fun save(movies: List<Movie>)
}

class MoviesRoomDataSource @Inject constructor(
    private val moviesDao: MoviesDao
) : MoviesLocalDataSource {

    override val movies: Flow<List<Movie>> =
        moviesDao.fetchPopularMovies().map { movies -> movies.map { it.toDomainMovie() } }

    override fun findMovieById(id: Int): Flow<Movie?> = moviesDao.findMovieById(id).map { it?.toDomainMovie() }

    override suspend fun save(movies: List<Movie>) = moviesDao.save(movies.map { it.toDbMovie() })
}

private fun DbMovie.toDomainMovie(): Movie = Movie(
    id = id,
    title = title,
    overview = overview,
    poster = poster,
    backdrop = backdrop,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    isFavorite = isFavorite,
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    popularity = popularity
)

private fun Movie.toDbMovie(): DbMovie = DbMovie(
    id = id,
    title = title,
    overview = overview,
    poster = poster,
    backdrop = backdrop,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    isFavorite = isFavorite,
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    popularity = popularity
)