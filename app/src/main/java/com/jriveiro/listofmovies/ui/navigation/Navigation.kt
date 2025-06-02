package com.jriveiro.listofmovies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jriveiro.detail.DetailScreen
import com.jriveiro.detail.DetailViewModel
import com.jriveiro.home.ui.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.Home) {
        composable<NavScreen.Home> {
            com.jriveiro.home.ui.HomeScreen(onMovieClick = { movie ->
                navController.navigate(NavScreen.Detail(movie.id))
            })
        }
        composable<NavScreen.Detail>{ backStackEntry ->
            val viewModel: com.jriveiro.detail.DetailViewModel = hiltViewModel(backStackEntry)
            com.jriveiro.detail.DetailScreen(
                vm = viewModel,
                onBack = { navController.popBackStack() })
        }
    }
}