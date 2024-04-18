package com.example.fluttercompareapp.features.photos.di

import com.example.fluttercompareapp.features.photos.data.repositories.PhotosRepositoryImpl
import com.example.fluttercompareapp.features.photos.domain.repositories.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class PhotosRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPhotosRepository(
        photosRepositoryImpl: PhotosRepositoryImpl,
    ): PhotosRepository
}