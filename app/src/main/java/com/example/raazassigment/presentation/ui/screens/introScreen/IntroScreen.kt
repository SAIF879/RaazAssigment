package com.example.raazassigment.presentation.ui.screens.introScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.raazassigment.domain.util.questions
import com.example.raazassigment.presentation.navigation.NavGraph
import com.example.raazassigment.presentation.ui.components.OptionButton
import com.example.raazassigment.presentation.ui.components.SkipButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroScreen(navController: NavController) {


    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    val currentQuestion = questions[currentQuestionIndex]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                colors = TopAppBarDefaults.
                topAppBarColors(containerColor = Color(0xffD3E7F1)),
                actions = {
                    if (currentQuestionIndex == 0) {
                        SkipButton {
                            navController.navigate(NavGraph.AUTHENTICATION)
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffD3E7F1))
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentQuestion.text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            currentQuestion.options.forEach { option ->
                OptionButton(option = option) {
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                    } else {
                        navController.navigate(NavGraph.AUTHENTICATION)
                    }
                }
            }
        }
    }
}
