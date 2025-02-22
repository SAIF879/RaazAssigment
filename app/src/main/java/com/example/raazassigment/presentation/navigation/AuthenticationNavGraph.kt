package com.example.raazassigment.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.raazassigment.presentation.ui.screens.authenticationScreen.AuthenticationScreen

fun NavGraphBuilder.authenticationNavGraph(navController: NavController) {
    navigation(
        route = NavGraph.AUTHENTICATION,
        startDestination = AuthenticationScreens.AuthenticationScreen.route
    ) {
        composable(route = AuthenticationScreens.AuthenticationScreen.route) {
     AuthenticationScreen(navController)
        }
    }
}

sealed class AuthenticationScreens(val route: String) {
    data object AuthenticationScreen : AuthenticationScreens(route = "authentication_screen")
}