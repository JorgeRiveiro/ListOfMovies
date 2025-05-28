package com.jriveiro.listofmovies.data.datasources

import com.jriveiro.listofmovies.data.Movie
import com.jriveiro.listofmovies.data.datasources.database.MoviesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesLocalDataSource @Inject constructor(
    private val moviesDao: MoviesDao
) {

    val movies: Flow<List<Movie>> = moviesDao.fetchPopularMovies()

    fun findMovieById(id: Int): Flow<Movie?> = moviesDao.findMovieById(id)

    suspend fun save(movies: List<Movie>) = moviesDao.save(movies)
}