package com.example.raazassigment.presentation.ui.screens.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raazassigment.domain.model.QuizResponseEntity
import com.example.raazassigment.domain.usecase.GetQuizResponsesUseCase
import com.example.raazassigment.domain.usecase.SaveQuizResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getQuizResponsesUseCase: GetQuizResponsesUseCase
) : ViewModel() {

    private val _quizResponses = MutableStateFlow<List<QuizResponseEntity>>(emptyList())
    val quizResponses = _quizResponses.asStateFlow()

    init {
        getQuizResponses()
    }

    private fun getQuizResponses() {
        viewModelScope.launch {
            getQuizResponsesUseCase.execute().collect { responses ->
                _quizResponses.value = responses
            }
        }
    }
}