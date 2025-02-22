package com.example.raazassigment.presentation.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.raazassigment.presentation.ui.screens.introScreen.IntroScreen

fun NavGraphBuilder.introNavGraph(navController: NavController) {
    navigation(
        route = NavGraph.INTRO,
        startDestination = IntroScreens.IntroductionScreen.route
    ) {
        composable(route = IntroScreens.IntroductionScreen.route) {
            IntroScreen(navController)
        }
    }
}

sealed class IntroScreens(val route: String) {
    data object IntroductionScreen : IntroScreens(route = "introduction_screen")
}