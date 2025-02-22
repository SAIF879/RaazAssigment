package com.example.raazassigment.presentation.ui.screens.mainScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.raazassigment.presentation.navigation.BottomNavGraph
import com.example.raazassigment.presentation.ui.components.BottomBar

sealed class BottomBarScreens(
    val route: String,
    val title: String
) {
    data  object Search : BottomBarScreens(
        route = "search",
        title = "Market"
    )

    data object Home : BottomBarScreens(
        route = "home",
        title = "History"
    )

    data object Profile : BottomBarScreens(
        route = "profile",
        title = "Search"
    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()

    val showBottomBar = rememberSaveable {
        mutableStateOf(true)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        "search" -> showBottomBar.value = true
        "home" -> showBottomBar.value = true
        "profile" -> showBottomBar.value = true
        else -> showBottomBar.value = false
    }
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController, showBottomBar)
        },
    ) {
        BottomNavGraph(navHostController = navController)
    }
}
