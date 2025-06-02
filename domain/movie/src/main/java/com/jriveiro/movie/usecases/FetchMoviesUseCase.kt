package com.jriveiro.movie.usecases

import com.jriveiro.domain.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(
    private val moviesRepository: com.jriveiro.data.MoviesRepository
) {
    operator fun invoke() : Flow<List<Movie>> = moviesRepository.movies
}