package com.example.raazassigment.domain.usecase

import com.example.raazassigment.domain.model.QuizResponseEntity
import com.example.raazassigment.domain.repo.QuizRepository
import javax.inject.Inject

class SaveQuizResponseUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    suspend operator fun invoke(responses: List<QuizResponseEntity>) {
        repository.saveAllQuizResponses(responses)
    }
}
