package com.example.raazassigment.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.raazassigment.presentation.ui.screens.authenticationScreen.AuthenticationScreen
import com.example.raazassigment.presentation.ui.screens.landingScreen.LandingScreen
import com.example.raazassigment.presentation.ui.screens.landingScreen.LandingScreenEvents

fun NavGraphBuilder.authenticationNavGraph(navController: NavController) {
    navigation(
        route = NavGraph.AUTHENTICATION,
        startDestination = AuthenticationScreens.LandingScreen.route
    ) {
        composable(route = AuthenticationScreens.LandingScreen.route){
            LandingScreen(navController  ){
               when(it){
                   is LandingScreenEvents.OnNavigateToLogin -> {
                       navController.navigate(AuthenticationScreens.AuthenticationScreen.route + "/${true}")
                   }
               }
            }
        }
//        composable(route = AuthenticationScreens.AuthenticationScreen.route +"/isLogin", arguments = listOf(
//            navArgument("isLogin"){type= NavType.BoolType}
//        )) {backStackEntry->
//     AuthenticationScreen(navController , backStackEntry.arguments?.getBoolean("isLogin") ?: false)
//        }
        composable(
            route = AuthenticationScreens.AuthenticationScreen.route + "/{isLogin}",
            arguments = listOf(navArgument("isLogin") { type = NavType.BoolType })
        ) { backStackEntry ->
            val isLogin = backStackEntry.arguments?.getBoolean("isLogin") ?: false
            AuthenticationScreen(navController, isLogin)
        }

    }
}

sealed class AuthenticationScreens(val route: String) {
    data object LandingScreen : AuthenticationScreens(route = "landing_screen")
    data object AuthenticationScreen : AuthenticationScreens(route = "authentication_screen")

}