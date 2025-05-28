package com.jriveiro.listofmovies.ui.screens.home

import android.Manifest
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.jriveiro.listofmovies.ui.common.PermissionRequestEffect
import com.jriveiro.listofmovies.ui.common.getRegion
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class HomeState(
    val scrollBehavior: TopAppBarScrollBehavior
) {
    @Composable
    fun AskRegionEffect(onRegion: (String) -> Unit) {
        val coroutineScope = rememberCoroutineScope()
        val ctx = LocalContext.current.applicationContext

        PermissionRequestEffect(permission = Manifest.permission.ACCESS_COARSE_LOCATION) { granted ->
            coroutineScope.launch {
                val region = if (granted) ctx.getRegion() else "ES"
                onRegion(region)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberHomeState(
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
) = remember { HomeState(scrollBehavior) }