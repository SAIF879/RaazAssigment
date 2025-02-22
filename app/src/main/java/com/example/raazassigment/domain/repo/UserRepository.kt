package com.example.raazassigment.domain.repo

import com.example.raazassigment.domain.model.UserEntity


interface UserRepository {
    suspend fun insertUser(user: UserEntity)
    suspend fun getUser(email: String, password: String): UserEntity?
}