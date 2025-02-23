package com.example.raazassigment.presentation.ui.screens.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raazassigment.domain.model.QuizResponseEntity
import com.example.raazassigment.domain.usecase.GetQuizResponsesUseCase
import com.example.raazassigment.domain.usecase.SaveQuizResponseUseCase
import com.example.raazassigment.presentation.util.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    private val getQuizResponsesUseCase: GetQuizResponsesUseCase
) : ViewModel() {

    private val _quizResponses = MutableStateFlow<List<QuizResponseEntity>>(emptyList())
    val quizResponses = _quizResponses.asStateFlow()

    init {
        getQuizResponses()
    }

    val userEmail: StateFlow<String?> = userPreferences.userEmail.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )

    private fun getQuizResponses() {
        viewModelScope.launch {
            getQuizResponsesUseCase.execute().collect { responses ->
                _quizResponses.value = responses
            }
        }
    }
}