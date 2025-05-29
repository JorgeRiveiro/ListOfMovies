package com.jriveiro.listofmovies.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.jriveiro.listofmovies.Result
import com.jriveiro.listofmovies.data.Movie
import com.jriveiro.listofmovies.data.MoviesRepository
import com.jriveiro.listofmovies.ifSuccess
import com.jriveiro.listofmovies.stateAsResultIn
import com.jriveiro.listofmovies.usecases.FindMovieByIdUseCase
import com.jriveiro.listofmovies.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel@Inject constructor(
    findMovieByIdUseCase: FindMovieByIdUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val id: Int = savedStateHandle["id"]
        ?: throw IllegalArgumentException("User ID not found in saved state")

    val state: StateFlow<Result<Movie>> = findMovieByIdUseCase(id)
        .stateAsResultIn(scope = viewModelScope)

    fun onFavoriteClicked() {
        state.value.ifSuccess {
            viewModelScope.launch {
                toggleFavoriteUseCase(it)
            }
        }
    }
}