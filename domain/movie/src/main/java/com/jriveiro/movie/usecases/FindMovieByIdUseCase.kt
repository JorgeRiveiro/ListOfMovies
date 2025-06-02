package com.jriveiro.movie.usecases

import com.jriveiro.domain.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindMovieByIdUseCase @Inject constructor(
    private val moviesRepository: com.jriveiro.data.MoviesRepository
) {
    operator fun invoke(id: Int): Flow<Movie> = moviesRepository.findMovieById(id)
}