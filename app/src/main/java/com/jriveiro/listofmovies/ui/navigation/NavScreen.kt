package com.jriveiro.listofmovies.ui.navigation

import kotlinx.serialization.Serializable

sealed class NavScreen {
    @Serializable
    object Home

    @Serializable
    data class Detail(val id: Int)
}