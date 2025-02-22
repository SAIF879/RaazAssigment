package com.example.raazassigment.presentation.ui.screens.landingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.raazassigment.presentation.navigation.AuthenticationScreens
import com.example.raazassigment.presentation.ui.components.AppCompactButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Add a title if needed */ },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    AppCompactButton(
                        label = "LOG IN", color = Color.White,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                    ) {
                        navController.navigate(AuthenticationScreens.AuthenticationScreen.route)

                    }

                    AppCompactButton(
                        label = "REGISTER",
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                    ) {
                        navController.navigate(AuthenticationScreens.AuthenticationScreen.route)
                    }


                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff0F3141))
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}
