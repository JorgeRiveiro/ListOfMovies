package com.jriveiro.listofmovies.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jriveiro.listofmovies.ui.theme.ListOfMoviesTheme

@Composable
fun Screen(content: @Composable () -> Unit) {
    ListOfMoviesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            content = content
        )
    }
}