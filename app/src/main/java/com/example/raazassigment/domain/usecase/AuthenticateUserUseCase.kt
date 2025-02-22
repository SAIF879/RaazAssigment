package com.example.raazassigment.domain.usecase

import com.example.raazassigment.domain.model.UserEntity
import com.example.raazassigment.domain.repo.UserRepository
import javax.inject.Inject


class AuthenticateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend fun registerUser(email: String, password: String) {
        val newUser = UserEntity(email, password)
        repository.insertUser(newUser)
    }

    suspend fun loginUser(email: String, password: String): Boolean {
        return repository.getUser(email, password) != null
    }
}