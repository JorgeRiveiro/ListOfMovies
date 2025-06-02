package com.jriveiro.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jriveiro.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import com.jriveiro.domain.Movie
import com.jriveiro.common.stateAsResultIn
import com.jriveiro.movie.usecases.FetchMoviesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModel @Inject constructor(
    private val fetchMoviesUseCase: com.jriveiro.movie.usecases.FetchMoviesUseCase,
): ViewModel() {

    private val uiReady = MutableStateFlow(false)

    val state: StateFlow<com.jriveiro.common.Result<List<Movie>>> = uiReady
        .filter { it }
        .flatMapLatest { fetchMoviesUseCase() }
        .stateAsResultIn(viewModelScope)

    fun onUiReady() {
        uiReady.value = true
    }
}