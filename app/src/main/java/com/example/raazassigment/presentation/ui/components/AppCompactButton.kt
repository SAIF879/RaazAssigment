package com.example.raazassigment.presentation.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun AppCompactButton(label: String, color: Color = Color.Black, modifier: Modifier, onClick: () -> Unit ) {
    Button(
        onClick = {
            onClick.invoke()
        }, elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        modifier = modifier,

        shape = RectangleShape
    ) {
        Text(text = label, color = if(color==Color.Black) Color.White else Color.Black)
    }
}