package com.jriveiro.listofmovies.data

import com.jriveiro.listofmovies.data.datasources.MoviesRemoteDataSource
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val regionRepository: RegionRepository,
    private val remoteDataSource: MoviesRemoteDataSource
) {

    suspend fun fetchPopularMovies(): List<Movie> = remoteDataSource.fetchPopularMovies(regionRepository.findLastRegion())

    suspend fun findMovieById(id: Int): Movie = remoteDataSource.findMovieById(id)

}
