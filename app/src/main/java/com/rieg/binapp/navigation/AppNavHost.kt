package com.rieg.binapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rieg.binapp.presentation.history.HistoryScreen
import com.rieg.binapp.presentation.main.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object MainRoute

@Serializable
object HistoryRoute


@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute
    ) {
        composable<MainRoute> {
            MainScreen(
                navigateToHistory = {
                    navController.navigate(route = HistoryRoute) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<HistoryRoute> {
            HistoryScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
