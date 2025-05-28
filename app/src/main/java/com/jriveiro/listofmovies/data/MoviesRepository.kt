package com.jriveiro.listofmovies.data

import com.jriveiro.listofmovies.data.datasources.MoviesLocalDataSource
import com.jriveiro.listofmovies.data.datasources.MoviesRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val regionRepository: RegionRepository,
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MoviesLocalDataSource
) {

    val movies: Flow<List<Movie>> = localDataSource.movies.transform { localMovies ->
        val movies = localMovies.takeIf { it.isNotEmpty() }
            ?: remoteDataSource.fetchPopularMovies(regionRepository.findLastRegion()).also {
                localDataSource.save(it)
            }
        emit(movies)
    }

    fun findMovieById(id: Int): Flow<Movie> =
        localDataSource.findMovieById(id).transform { localMovie ->
            val movie = localMovie
                ?: remoteDataSource.findMovieById(id).also { localDataSource.save(listOf(it)) }
            emit(movie)
        }
}
