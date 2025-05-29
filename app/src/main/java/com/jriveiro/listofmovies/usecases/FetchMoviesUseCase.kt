package com.jriveiro.listofmovies.usecases

import com.jriveiro.listofmovies.domain.Movie
import com.jriveiro.listofmovies.data.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke() : Flow<List<Movie>> = moviesRepository.movies
}