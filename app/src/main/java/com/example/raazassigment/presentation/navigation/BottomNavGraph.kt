package com.example.raazassigment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.raazassigment.presentation.ui.screens.mainScreen.BottomBarScreens
@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarScreens.Profile.route) {
        composable(BottomBarScreens.Search.route) {
            //SearchScreen(navController)
        }
        composable(BottomBarScreens.Home.route) {
           // HomeScreen(navController)
        }
        composable(BottomBarScreens.Profile.route) {
          //  ProfileScreen(navController)
        }
    }
}
