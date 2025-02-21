package com.example.raazassigment.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.introNavGraph(navController: NavController) {
    navigation(
        route = NavGraph.INTRO,
        startDestination = IntroScreens.IntroductionScreen.route
    ) {
        composable(route = IntroScreens.IntroductionScreen.route) {
            TODO("INTRODUCTION SCREEN IMPL")
        }
    }
}

sealed class IntroScreens(val route: String) {
    data object IntroductionScreen : SplashScreens(route = "introduction_screen")
}