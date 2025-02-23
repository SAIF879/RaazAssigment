package com.example.raazassigment.domain.usecase

import com.example.raazassigment.domain.model.QuizResponseEntity
import com.example.raazassigment.domain.repo.QuizRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuizResponsesUseCase @Inject constructor(
    private val quizRepository: QuizRepository
) {
    fun execute(): Flow<List<QuizResponseEntity>> = flow {
        emit(quizRepository.getQuizResponses())
    }
}