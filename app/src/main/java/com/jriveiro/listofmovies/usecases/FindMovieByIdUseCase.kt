package com.jriveiro.listofmovies.usecases

import com.jriveiro.listofmovies.domain.Movie
import com.jriveiro.listofmovies.data.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindMovieByIdUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(id: Int): Flow<Movie> = moviesRepository.findMovieById(id)
}