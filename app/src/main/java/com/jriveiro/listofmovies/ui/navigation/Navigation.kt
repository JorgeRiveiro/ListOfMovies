package com.jriveiro.listofmovies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jriveiro.listofmovies.ui.screens.details.DetailScreen
import com.jriveiro.listofmovies.ui.screens.details.DetailViewModel
import com.jriveiro.listofmovies.ui.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.Home) {
        composable<NavScreen.Home> {
            HomeScreen(onMovieClick = { movie ->
                navController.navigate(NavScreen.Detail(movie.id))
            })
        }
        composable<NavScreen.Detail>{ backStackEntry ->
            val viewModel: DetailViewModel = hiltViewModel(backStackEntry)
            DetailScreen(
                vm = viewModel,
                onBack = { navController.popBackStack() })
        }
    }
}