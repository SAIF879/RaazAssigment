package com.example.raazassigment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.raazassigment.presentation.ui.components.BottomBarScreens
import com.example.raazassigment.presentation.ui.screens.homeScreen.HomeScreen
import com.example.raazassigment.presentation.ui.screens.profileScreen.ProfileScreen
import com.example.raazassigment.presentation.ui.screens.searchScreen.SearchScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarScreens.Home.route) {
        composable(BottomBarScreens.Search.route) {
           SearchScreen()
        }
        composable(BottomBarScreens.Home.route) {
        HomeScreen()
        }
        composable(BottomBarScreens.Profile.route) {
            ProfileScreen()
        }
    }
}
