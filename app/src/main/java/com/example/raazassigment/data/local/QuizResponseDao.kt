package com.example.raazassigment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.raazassigment.domain.model.QuizResponseEntity

@Dao
interface QuizResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(responses: List<QuizResponseEntity>)

    @Query("SELECT * FROM quiz_responses")
    suspend fun getAllResponses(): List<QuizResponseEntity>
}