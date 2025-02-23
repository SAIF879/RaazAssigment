package com.example.raazassigment.presentation.ui.screens.mainScreen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.raazassigment.presentation.navigation.BottomNavGraph
import com.example.raazassigment.presentation.ui.components.BottomBar



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
