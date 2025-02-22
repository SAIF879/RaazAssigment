package com.example.raazassigment.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.raazassigment.presentation.ui.screens.authenticationScreen.AuthenticationScreen
import com.example.raazassigment.presentation.ui.screens.landingScreen.LandingScreen

fun NavGraphBuilder.authenticationNavGraph(navController: NavController) {
    navigation(
        route = NavGraph.AUTHENTICATION,
        startDestination = AuthenticationScreens.LandingScreen.route
    ) {
        composable(route = AuthenticationScreens.LandingScreen.route){
            LandingScreen(navController)
        }
        composable(route = AuthenticationScreens.AuthenticationScreen.route) {
     AuthenticationScreen(navController)
        }
    }
}

sealed class AuthenticationScreens(val route: String) {
    data object LandingScreen : AuthenticationScreens(route = "landing_screen")
    data object AuthenticationScreen : AuthenticationScreens(route = "authentication_screen")

}