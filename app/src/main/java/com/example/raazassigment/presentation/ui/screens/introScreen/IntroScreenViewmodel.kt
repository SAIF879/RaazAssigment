package com.example.raazassigment.presentation.ui.screens.introScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raazassigment.domain.model.Question
import com.example.raazassigment.domain.model.QuizResponseEntity
import com.example.raazassigment.domain.usecase.SaveQuizResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val saveQuizResponseUseCase: SaveQuizResponseUseCase
) : ViewModel() {

    private val _responses = mutableListOf<QuizResponseEntity>()

    fun saveQuizResponse(question: String, selectedOption: String, isLast: Boolean) {
        _responses.add(QuizResponseEntity(question = question, selectedOption = selectedOption))

        Log.d("QuizViewModel", "Collected response: $question -> $selectedOption")

        if (isLast) {
            viewModelScope.launch {
                Log.d("QuizViewModel", "Saving responses: $_responses")
                saveQuizResponseUseCase(_responses)
                _responses.clear()
                Log.d("QuizViewModel", "Responses saved and cleared.")
            }
        }
    }
}
