package com.example.raazassigment.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.raazassigment.data.local.AppDatabase
import com.example.raazassigment.data.local.UserDao
import com.example.raazassigment.data.repo.UserRepositoryImpl
import com.example.raazassigment.domain.repo.UserRepository
import com.example.raazassigment.domain.usecase.AuthenticateUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }

    @Provides
    fun provideAuthenticateUserUseCase(repository: UserRepository): AuthenticateUserUseCase {
        return AuthenticateUserUseCase(repository)
    }
}