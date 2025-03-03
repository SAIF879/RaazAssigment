package com.example.raazassigment.presentation.ui.screens.authenticationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raazassigment.domain.usecase.AuthenticateUserUseCase
import com.example.raazassigment.presentation.util.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    private val authenticateUserUseCase: AuthenticateUserUseCase
) : ViewModel() {

    fun registerUser(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            authenticateUserUseCase.registerUser(email, password)
            onSuccess()
        }
    }

    fun saveEmail(email: String) {
        viewModelScope.launch {
            userPreferences.saveUserEmail(email)
        }
    }

    fun loginUser(email: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {
        viewModelScope.launch {
            if (authenticateUserUseCase.loginUser(email, password)) {
                onSuccess()
            } else {
                onError()
            }
        }
    }
}