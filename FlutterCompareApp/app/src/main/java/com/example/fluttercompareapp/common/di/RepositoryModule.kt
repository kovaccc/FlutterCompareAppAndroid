package com.example.fluttercompareapp.common.di

import com.example.fluttercompareapp.features.auth.register.data.repositories.AuthRepository
import com.example.fluttercompareapp.features.auth.register.data.repositories.AuthRepositoryImpl
import com.example.fluttercompareapp.features.photos.data.repositories.PhotosRepository
import com.example.fluttercompareapp.features.photos.data.repositories.PhotosRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindPhotosRepository(
        photosRepositoryImpl: PhotosRepositoryImpl,
    ): PhotosRepository
}