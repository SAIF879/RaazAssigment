package com.example.raazassigment.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBox(text: MutableState<String> , label: String) {
    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = {
            Text(
                text = label,
                color = Color.Black, // Label text color
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
        },
        textStyle = androidx.compose.ui.text.TextStyle(
            color = Color.Black, // Input text color
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White, // Background color
            focusedBorderColor = Color.Black, // Border color when focused
            unfocusedBorderColor = Color.Black, // Border color when unfocused
            cursorColor = Color.Black // Cursor color
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}
