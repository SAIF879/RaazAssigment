package com.example.raazassigment.presentation.ui.screens.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.raazassigment.R
import com.example.raazassigment.domain.model.QuizResponseEntity
import com.example.raazassigment.presentation.ui.components.AppCompactButton
import com.example.raazassigment.presentation.ui.components.QuizItem
import com.example.raazassigment.presentation.util.showToast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(viewModel: ProfileViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val quizResponses by viewModel.quizResponses.collectAsState()
    val userEmail by viewModel.userEmail.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Welcome to Raaz App") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Section
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .padding(10.dp)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_account),
                        contentDescription = "Profile Icon",
                        modifier = Modifier.size(60.dp),
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = userEmail?:"NULL",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .padding(10.dp)
                    .padding(vertical = 10.dp)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        Text(
                            text = "DETAILS WE KNOW ABOUT YOU",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    items(quizResponses) { response ->
                        QuizItem(response)
                    }
                }
            }

            // Bottom Section
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth() .padding(10.dp)
            ) {
                Text(
                    text = "BROWSE YOUR REPORTS",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                AppCompactButton(
                    label = "SEE MORE",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    color = Color.White,
                ) {
                    context.showToast("Coming Soon!")
                }
                Spacer(modifier = Modifier.size(100.dp))
            }
        }
    }
}
