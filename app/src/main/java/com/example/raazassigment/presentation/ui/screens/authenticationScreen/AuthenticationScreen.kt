package com.example.raazassigment.presentation.ui.screens.authenticationScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.raazassigment.presentation.ui.components.AppCompactButton
import com.example.raazassigment.presentation.ui.components.InputBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationScreen(navController: NavController , isFromLogin : Boolean,     viewModel: AuthViewModel = hiltViewModel()) {
    val email = remember {
        mutableStateOf("")
    }
    val passWord = remember {

        mutableStateOf("")
    }
    val context = LocalContext.current
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
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White
                )
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = if (isFromLogin) "Log In" else "Register",
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(10.dp)
                )
            }


            InputBox(email, "Email")
            InputBox(passWord, "Password")


            AppCompactButton(
                label = if(isFromLogin) "Log In" else "Next"
                , modifier = Modifier.fillMaxWidth()
                    .height(70.dp)
                    .padding(10.dp)
            ) {
                if (isFromLogin) {
                    viewModel.loginUser(
                        email.value,
                        passWord.value,
                        onSuccess = {
                            Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT)
                                .show()
                            navController.navigate("next_screen")

                        },
                        onError = {
                            Toast.makeText(
                                context,
                                "Invalid Credentials",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                } else {
                    viewModel.registerUser(email.value, passWord.value) {
                        Toast.makeText(context, "Registered Successfully", Toast.LENGTH_SHORT)
                            .show()
                    }
                }


            }
        }
    }
}
