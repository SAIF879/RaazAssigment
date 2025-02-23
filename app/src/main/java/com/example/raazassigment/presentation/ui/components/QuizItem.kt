package com.example.raazassigment.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.raazassigment.domain.model.QuizResponseEntity


@Composable
fun QuizItem(response: QuizResponseEntity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
            .padding(10.dp)
    ) {
        Text(text = "Question: ${response.question}", fontWeight = FontWeight.Bold)
        Text(text = "Selected Option: ${response.selectedOption}", fontSize = 14.sp)
    }
}
