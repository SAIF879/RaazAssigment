package com.example.raazassigment.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_responses")
data class QuizResponseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val question: String,
    val selectedOption: String
)