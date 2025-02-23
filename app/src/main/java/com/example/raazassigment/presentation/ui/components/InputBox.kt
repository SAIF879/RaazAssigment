package com.example.raazassigment.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import com.example.raazassigment.R
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale


@Composable
fun InputBox(text: MutableState<String>, label: String , isPassWord : Boolean =false) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = text.value.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
        onValueChange = { text.value = it },
        label = {
            Text(
                text = label,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        },
        placeholder = {
            Text(text = "Enter $label", color = Color.Black , fontSize = 12.sp)
        },
        textStyle = androidx.compose.ui.text.TextStyle(
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Black,
            unfocusedLabelColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedPrefixColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedSuffixColor = Color.White,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            unfocusedTextColor = Color.Gray,
        ),

        visualTransformation = if (isPassWord && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isPassWord) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(
                            id = if (passwordVisible) R.drawable.ic_visiblity else R.drawable.ic_visiblity_off
                        ),
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            }
        },



        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}
