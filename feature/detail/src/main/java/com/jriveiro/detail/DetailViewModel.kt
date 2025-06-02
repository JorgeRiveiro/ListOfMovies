package com.jriveiro.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.jriveiro.common.Result
import com.jriveiro.domain.Movie
import com.jriveiro.common.ifSuccess
import com.jriveiro.common.stateAsResultIn
import com.jriveiro.movie.usecases.FindMovieByIdUseCase
import com.jriveiro.movie.usecases.ToggleFavoriteUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel@Inject constructor(
    findMovieByIdUseCase: com.jriveiro.movie.usecases.FindMovieByIdUseCase,
    private val toggleFavoriteUseCase: com.jriveiro.movie.usecases.ToggleFavoriteUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val id: Int = savedStateHandle["id"]
        ?: throw IllegalArgumentException("User ID not found in saved state")

    val state: StateFlow<com.jriveiro.common.Result<Movie>> = findMovieByIdUseCase(id)
        .stateAsResultIn(scope = viewModelScope)

    fun onFavoriteClicked() {
        state.value.ifSuccess {
            viewModelScope.launch {
                toggleFavoriteUseCase(it)
            }
        }
    }
}