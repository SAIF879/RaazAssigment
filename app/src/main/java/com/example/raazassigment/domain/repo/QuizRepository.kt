package com.example.raazassigment.domain.repo

import com.example.raazassigment.domain.model.QuizResponseEntity

interface QuizRepository {
    suspend fun saveAllQuizResponses(responses: List<QuizResponseEntity>)
    suspend fun getQuizResponses(): List<QuizResponseEntity>
}
