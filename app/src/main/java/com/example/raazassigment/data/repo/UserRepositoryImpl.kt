package com.example.raazassigment.data.repo

import com.example.raazassigment.data.local.UserDao
import com.example.raazassigment.domain.model.UserEntity
import com.example.raazassigment.domain.repo.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    override suspend fun getUser(email: String, password: String): UserEntity? {
        return userDao.getUser(email, password)
    }


}