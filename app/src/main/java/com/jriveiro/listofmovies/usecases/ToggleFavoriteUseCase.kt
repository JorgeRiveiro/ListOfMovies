package com.jriveiro.listofmovies.usecases

import com.jriveiro.listofmovies.data.Movie
import com.jriveiro.listofmovies.data.MoviesRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(movie : Movie){
        moviesRepository.toggleFavorite(movie)
    }
}