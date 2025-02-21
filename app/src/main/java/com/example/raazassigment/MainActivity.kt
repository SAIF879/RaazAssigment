package com.example.raazassigment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.raazassigment.presentation.navigation.RootNavGraph
import com.example.raazassigment.presentation.theme.RaazAssigmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RaazAssigmentTheme {
               RootNavGraph(navController = rememberNavController())
            }
        }
    }
}
