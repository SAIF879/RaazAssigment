package com.example.raazassigment.presentation.ui.screens.landingScreen

sealed class LandingScreenEvents{
    data class OnNavigateToLogin(val isLogin : Boolean) :LandingScreenEvents()
}