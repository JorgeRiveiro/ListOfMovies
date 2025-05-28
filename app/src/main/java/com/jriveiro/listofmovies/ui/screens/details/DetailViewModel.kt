package com.jriveiro.listofmovies.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jriveiro.listofmovies.data.Movie
import com.jriveiro.listofmovies.data.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailViewModel@Inject constructor(
    repository: MoviesRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val id: Int = savedStateHandle["id"]
        ?: throw IllegalArgumentException("User ID not found in saved state")

    private val message = MutableStateFlow<String?>(null)
    val state: StateFlow<UiState> =
        combine(repository.findMovieById(id), message) { movie, message ->
            UiState(
                loading = false,
                movie = movie,
                message = message
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState(loading = true)
        )

    data class UiState(
        val loading: Boolean = false,
        val movie: Movie? = null,
        val message: String? = null
    )

    fun onFavoriteClicked() {
        message.value = null
    }

    fun onMessageShown() {
        message.value = null
    }
}