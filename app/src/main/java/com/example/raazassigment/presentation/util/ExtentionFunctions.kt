package com.example.raazassigment.presentation.util

import android.content.Context
import android.widget.Toast

fun String.isValidEmail(): Boolean {
    return Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$").matches(this)
}
fun String.isValidPassword(): Boolean {
    return this.length >= 8
}

fun Context.showToast(text:String){
    Toast.makeText(this, text , Toast.LENGTH_SHORT).show()
}