package com.example.raazassigment.presentation.ui.screens.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.raazassigment.presentation.ui.components.AppCompactButton

@Composable
fun ProfileScreen() {
Column(modifier = Modifier.fillMaxSize() , verticalArrangement = Arrangement.SpaceBetween , horizontalAlignment = Alignment.CenterHorizontally) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Icon
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray, shape = CircleShape)
                .padding(16.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Email Field
        Text(
            text = "Email:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Actual Email (Replace with dynamic email)
        Text(
            text = "user@example.com", // Change this to actual email from ViewModel
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
}

Column(
    modifier = Modifier
        .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {

    Text(text = "Browse your reports",    fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Gray)

    AppCompactButton(label = "SEE MORE", modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .height(50.dp) , color = Color.White ) {

    }
    
    Spacer(modifier = Modifier.size(150.dp))
}
    }
}
