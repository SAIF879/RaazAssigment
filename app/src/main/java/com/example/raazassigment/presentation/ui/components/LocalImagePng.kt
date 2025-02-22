package com.example.raazassigment.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.raazassigment.R


@Composable
fun LocalPngImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.raaz_icon), // Replace with your image
        contentDescription = "Your PNG Image",
        modifier = modifier
    )
}