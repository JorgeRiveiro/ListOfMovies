package com.jriveiro.movie.usecases

import com.jriveiro.domain.Movie
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val moviesRepository: com.jriveiro.data.MoviesRepository
) {
    suspend operator fun invoke(movie : Movie){
        moviesRepository.toggleFavorite(movie)
    }
}