package com.example.raazassigment.data.repo


import com.example.raazassigment.data.local.QuizResponseDao
import com.example.raazassigment.domain.model.QuizResponseEntity
import com.example.raazassigment.domain.repo.QuizRepository
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val quizResponseDao: QuizResponseDao
) : QuizRepository {
    override suspend fun saveAllQuizResponses(responses: List<QuizResponseEntity>) {
        return quizResponseDao.insertAll(responses)
    }


    override suspend fun getQuizResponses(): List<QuizResponseEntity> {
        return quizResponseDao.getAllResponses()
    }
}