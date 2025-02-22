package com.example.raazassigment.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OptionButton(option : String,onClick: () -> Unit) {
    Button(onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffECE6F0)),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 10.dp)

    ) {
        Row(modifier = Modifier.fillMaxWidth() , verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Center) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                tint = Color(0xff65558F),
                modifier = Modifier.size(20.dp) // Adjust size if needed
            )
            Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
            Text(text = option, color =Color(0xff65558F))
        }
    }
}