package com.example.raazassigment.domain.util

import com.example.raazassigment.domain.model.Question

val questions = listOf(
    Question(
        text = "What is your favourite colour?",
        options = listOf("Blue", "Red", "Green")
    ),
    Question(
        text = "Do you have a pet?",
        options = listOf("Yes", "No")
    ),
    Question(
        text = "Which is your most visited city?",
        options = listOf("Mumbai", "Delhi", "Pune"),
    ),
    Question(
        text = "When did you graduate?",
        options = listOf("2021", "2022", "2023")
    )
)